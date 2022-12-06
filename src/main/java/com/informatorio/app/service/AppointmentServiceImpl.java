package com.informatorio.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.repository.IAppointmentDao;
import com.informatorio.app.wrapper.EventWrapper;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	
	
	@Autowired
	IAppointmentDao appointmentDao;
	/*@Override
	public Event createEvent(EventDto eventDto) throws AlreadyExistException, InvalidPasswordException {
		if (!eventDao.findByLocation(eventDto.getLocation()).isEmpty()
				&& !eventDao.findByEventDate(eventDto.getEventDate()).isEmpty()
				&& !eventDao.findByEventHour(eventDto.getEventHour()).isEmpty()) {
			throw new AlreadyExistException("This event already exist");
		}

		Organization org = orgDao.findById(eventDto.getOrganizationId()).orElse(new Organization());

		log.info(eventDto.getPassword());
		log.info(org.getPassword());
		if (eventDto.getPassword().trim().equals(org.getPassword().trim())) {
			Event event = EventWrapper.dtoToEntity(eventDto);
			event.setOrganization(org);

			return eventDao.save(event);
		} else {

			throw new InvalidPasswordException("Invalid Password ");
		}

	}*/

	@Override
	public Appointment create(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentDao.save(appointment);
	}

}
