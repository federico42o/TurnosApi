package com.informatorio.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.dto.response.EventResponseDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.BadRequestException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.repository.IOrgDao;
import com.informatorio.app.wrapper.EventWrapper;
import com.informatorio.app.wrapper.OrganizationWrapper;

@Service
public class EventServiceImpl implements IEventService {

	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	IOrgDao orgDao;
	@Autowired
	IEventDao eventDao;

	@Override
	public EventResponseDto createEvent(EventDto eventDto)
			throws AlreadyExistException, InvalidPasswordException, BadRequestException {

		Organization org = orgDao.findById(eventDto.getOrganizationId()).orElse(new Organization());

		if (!eventDao.findByIsActiveAndByNameAndOrg(eventDto.getOrganizationId(), eventDto.getName()).isEmpty()) {
			throw new AlreadyExistException("This event already exist");
		}

		if (eventDto.getPassword().trim().equals(org.getPassword().trim())) {
			Event event = EventWrapper.dtoToEntity(eventDto);
			event.setOrganization(org);
			event.setEventDate(eventDto.getEventDate());
			EventDto dto =  EventWrapper.entityToDto(eventDao.save(event));
			return EventWrapper.dtoToResponse(dto);
		} else {

			throw new InvalidPasswordException("Invalid Password");
		}

	}

	@Override
	public List<Event> findByAll() {

		List<Event> event = eventDao.findAll();


		return event;
	}

	public void delete(Long id) {

		eventDao.deleteById(id);

	}

}
