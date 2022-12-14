package com.informatorio.app.service.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.dto.response.EventResponseDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.BadRequestException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.repository.IOrgDao;
import com.informatorio.app.service.IEventService;
import com.informatorio.app.utils.CheckDate;
import com.informatorio.app.wrapper.EventWrapper;

@Service
public class EventServiceImpl implements IEventService {

	

	@Autowired
	IOrgDao orgDao;
	@Autowired
	IEventDao eventDao;

	@Override
	public EventResponseDto createEvent(EventDto eventDto)
			throws AlreadyExistException, InvalidPasswordException, BadRequestException {

		Organization org = orgDao.findById(eventDto.getOrganizationId()).orElse(new Organization());
		if (eventDto != null && !CheckDate.check(eventDto.getEventDate())) {
			throw new BadRequestException("it's not possible to create an event if the date has passed");
		}
		
		if (eventDto.getIsUnique() && eventDto.getEventHour() == null && eventDto.getEventDate() == null) {
			throw new BadRequestException("A unique event must have an hour and a date");
		}
		
		if (!eventDao.findByIsActiveAndByNameAndOrg(eventDto.getOrganizationId(), eventDto.getName()).isEmpty()) {
			throw new AlreadyExistException("This event already exist");
		}

		if (eventDto.getPassword().trim().equals(org.getPassword().trim())) {
			Event event = EventWrapper.dtoToEntity(eventDto);
			event.setOrganization(org);
			event.setEventDate(eventDto.getEventDate());
			EventDto dto = EventWrapper.entityToDto(eventDao.save(event));
			return EventWrapper.dtoToResponse(dto);
		} else {

			throw new InvalidPasswordException("Invalid Password");
		}

	}

	@Override
	public List<Event> findByAll() {

		List<Event> event = eventDao.findAll();
		event.stream().forEach(e -> e.setIsActive(CheckDate.check(e.getEventDate())));

		return event;
	}

	public void delete(Long id,Organization request) throws NotFoundException, InvalidPasswordException {
		if (eventDao.findById(id).isEmpty())throw new NotFoundException();
		Organization org = eventDao.findById(id).orElse(new Event()).getOrganization();
		if (!org.getPassword().equals(request.getPassword()))throw new InvalidPasswordException("Invalid password");
		

		eventDao.deleteById(id);

	}

	@Override
	public Event findByOrgAndByName(Long id,String name) {
		// TODO Auto-generated method stub
		
		
		
		return eventDao.findByOrgAndByName(id, name);
	}

	@Override
	public List<Event> findByOrgId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
