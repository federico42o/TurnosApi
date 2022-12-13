package com.informatorio.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.dto.response.EventResponseDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.BadRequestException;
import com.informatorio.app.exception.InvalidPasswordException;

public interface IEventService {

	EventResponseDto createEvent(EventDto eventDto) throws AlreadyExistException, InvalidPasswordException, BadRequestException;

	List<Event> findByAll();

	void delete(Long id, Organization org) throws NotFoundException, InvalidPasswordException;

	

}
