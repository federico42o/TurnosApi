package com.informatorio.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.entity.User;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.repository.IAppointmentDao;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.repository.IOrgDao;
import com.informatorio.app.repository.IUserDao;
import com.informatorio.app.service.IAppointmentService;
import com.informatorio.app.wrapper.AppointmentWrapper;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentDao appointmentDao;
	@Autowired
	IEventDao eventDao;
	@Autowired
	IUserDao userDao;
	@Autowired
	IOrgDao orgDao;

	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);

	@Transactional
	@Override
	public Appointment save(AppointmentDto appointment) throws AlreadyExistException {

		Appointment newAppointment = AppointmentWrapper.dtoToEntity(appointment);

		User user = userDao.findByDni(appointment.getDni());
		if (user != null && user.getDni().equals(appointment.getDni()) && (!user.getName().equals(appointment.getName())
				|| !user.getLastName().equals(appointment.getLastName()))) {
			throw new AlreadyExistException("this Dni belongs to another person");

		}
		if (user != null) {
			newAppointment.setUser(user);

		} else {
			User newUser = new User();
			newUser.setName(appointment.getName());
			newUser.setLastName(appointment.getLastName());
			newUser.setDni(appointment.getDni());
			userDao.save(newUser);
			newAppointment.setUser(newUser);
		}

		Event event = eventDao.findByName(appointment.getEventName()).get(0);
		newAppointment.setEvent(event);
		
		Organization org = orgDao.findByName(appointment.getOrgName());
		newAppointment.setOrganization(org);
		

		if (event.getIsUnique()) {
			newAppointment.setEventDate(event.getEventDate());
			newAppointment.setEventHour(event.getEventHour());
		} else {
			newAppointment.setEventDate(appointment.getEventDate());
			newAppointment.setEventHour(appointment.getEventHour());
		}
		return appointmentDao.save(newAppointment);
	}

	@Override
	public void cancel(Long id) throws NotFoundException {

		if (appointmentDao.findById(id).isEmpty())
			throw new NotFoundException();

		appointmentDao.deleteById(id);

	}
	
	@Transactional
	@Override
	public List<AppointmentDto> findAllByOrg(Long id) throws NotFoundException {
		
		Organization org = orgDao.findById(id).orElse(null);
		if (org == null) {
			throw new NotFoundException();
		}
		

		List<Appointment> appointments = appointmentDao.findAllByOrganizationId(id);

		
		
		List<AppointmentDto> appointmentsDto = appointments.stream()
			    .map(appointment -> {
			        AppointmentDto dto = new AppointmentDto();
					dto.setEventDate(appointment.getEventDate());
					dto.setEventHour(appointment.getEventHour());
			        dto.setEventName(appointment.getEvent().getName());
			        dto.setName(appointment.getUser().getName());
			        dto.setLastName(appointment.getUser().getLastName());
			        dto.setDni(appointment.getUser().getDni());
			        dto.setOrgName(appointment.getEvent().getOrganization().getName());

			        return dto;
			    })
			    .collect(Collectors.toList());

 		return appointmentsDto;
	}
	
	
	@Transactional
	@Override
	public List<AppointmentDto> findByIsActive(Long id) throws NotFoundException {
		
		Organization org = orgDao.findById(id).orElse(null);
		if (org == null) {
			throw new NotFoundException();
		}
		

		List<Appointment> appointments = appointmentDao.findAllByOrgIdAndByIsActive(id);

		
		
		List<AppointmentDto> appointmentsDto = appointments.stream()
			    .map(appointment -> {
			        AppointmentDto dto = new AppointmentDto();
					dto.setEventDate(appointment.getEventDate());
					dto.setEventHour(appointment.getEventHour());
			        dto.setEventName(appointment.getEvent().getName());
			        dto.setName(appointment.getUser().getName());
			        dto.setLastName(appointment.getUser().getLastName());
			        dto.setDni(appointment.getUser().getDni());
			        dto.setOrgName(appointment.getEvent().getOrganization().getName());

			        return dto;
			    })
			    .collect(Collectors.toList());

 		return appointmentsDto;
	}
	
	
	
	@Transactional
	@Override
	public List<AppointmentDto> findByEvent(Long id, String name) throws NotFoundException {
		Organization org = orgDao.findById(id).orElse(null);
		Event event = eventDao.findByOrgAndByName(id, name);
		if (org == null || event == null) {
			throw new NotFoundException();
		}
		

		List<Appointment> appointments = appointmentDao.findByOrganizationAndByEvent(id,event.getId());

		
		
		List<AppointmentDto> appointmentsDto = appointments.stream()
			    .map(appointment -> {
			        AppointmentDto dto = new AppointmentDto();
					dto.setEventDate(appointment.getEventDate());
					dto.setEventHour(appointment.getEventHour());
			        dto.setEventName(appointment.getEvent().getName());
			        dto.setName(appointment.getUser().getName());
			        dto.setLastName(appointment.getUser().getLastName());
			        dto.setDni(appointment.getUser().getDni());
			        dto.setOrgName(appointment.getEvent().getOrganization().getName());

			        return dto;
			    })
			    .collect(Collectors.toList());

 		return appointmentsDto;
	}

}
