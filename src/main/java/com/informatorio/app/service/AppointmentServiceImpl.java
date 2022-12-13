package com.informatorio.app.service;

import java.nio.channels.AlreadyBoundException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.User;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.repository.IAppointmentDao;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.repository.IUserDao;
import com.informatorio.app.wrapper.AppointmentWrapper;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentDao appointmentDao;
	@Autowired
	IEventDao eventDao;
	@Autowired
	IUserDao userDao;
	
	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
	@Transactional
	@Override
	public Appointment save(AppointmentDto appointment) throws AlreadyExistException {

		Appointment newAppointment = AppointmentWrapper.dtoToEntity(appointment);
		
		

		User user = userDao.findByDni(appointment.getDni());
		if (user != null && user.getDni().equals(appointment.getDni())
				&& (!user.getName().equals(appointment.getName()) || !user.getLastName().equals(appointment.getLastName()) ))
		{
			throw new AlreadyExistException("this Dni belongs to another person");
			
		}
		if (user != null) {
			newAppointment.setUser(user);

		}else {
			User newUser = new User();
			newUser.setName(appointment.getName());
			newUser.setLastName( appointment.getLastName());
			newUser.setDni(appointment.getDni());
			userDao.save(newUser);
			newAppointment.setUser(newUser);
		}

		Event event =  eventDao.findByName(appointment.getEventName()).get(0);
		newAppointment.setEvent(event);
		
		if (event.getIsUnique()) {
			newAppointment.setEventDate(event.getEventDate());
			newAppointment.setEventHour(event.getEventHour());
		}else {
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

}
