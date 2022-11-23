package com.informatorio.app.service;

import java.util.List;

import com.informatorio.app.dto.EventDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;

public interface IEventService {

	EventDto createEvent(EventDto eventDto) throws AlreadyExistException, InvalidPasswordException;

	List<Event> findByAll();

	void delete(Long id);

}
