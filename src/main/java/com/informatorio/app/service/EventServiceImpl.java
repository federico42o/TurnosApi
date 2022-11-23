package com.informatorio.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.EventDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.repository.IOrgDao;
import com.informatorio.app.wrapper.EventWrapper;

@Service
public class EventServiceImpl implements IEventService {

	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	IOrgDao orgDao;
	@Autowired
	IEventDao eventDao;

	@Override
	public EventDto createEvent(EventDto eventDto) throws AlreadyExistException, InvalidPasswordException {
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

			return EventWrapper.entityToDto(eventDao.save(event));
		} else {

			throw new InvalidPasswordException("Invalid Password! Try again");
		}

	}

	@Override
	public List<Event> findByAll() {
		List<Event> event = eventDao.findAll();
		// TODO Auto-generated method stub

		return event;
	}

	public void delete(Long id) {

		eventDao.deleteById(id);

	}

}
