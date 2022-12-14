package com.informatorio.app.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.dto.response.EventResponseDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.BadRequestException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.service.IEventService;
import com.informatorio.app.service.IOrgService;

@RestController
@RequestMapping("api/v1/event")
public class EventController {

	@Autowired
	IEventService eventService;
	@Autowired
	IOrgService orgService;

	@GetMapping
	public ResponseEntity<HashMap<String, Object>> all() {
		HashMap<String, Object> response = new HashMap<>();
		List<Event> all = eventService.findByAll();

		response.put("eventos", all);

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/new")
	public ResponseEntity<?> createEvent(@RequestBody @Valid EventDto eventDto)
			throws AlreadyExistException, InvalidPasswordException, NotFoundException, BadRequestException {

		HashMap<String, Object> response = new HashMap<>();

		EventResponseDto newEvent = eventService.createEvent(eventDto);

		response.put("event", newEvent);

		//return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.CREATED);
		return ResponseEntity.created(null).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEvent(@PathVariable Long id, @RequestBody Organization org) throws NotFoundException, InvalidPasswordException {

		eventService.delete(id, org);



	};

}
