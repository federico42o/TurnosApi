package com.informatorio.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.service.IAppointmentService;
import com.informatorio.app.service.IEventService;
import com.informatorio.app.service.IOrgService;
import com.informatorio.app.wrapper.AppointmentWrapper;

@RestController
@RequestMapping("api/v1/appointments")
public class AppointmentController {

	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	IOrgService orgService;
	@Autowired
	IEventService eventService;

	@GetMapping("/{orgId}")
	public ResponseEntity<HashMap<String, Object>> all(@PathVariable Long orgId) throws NotFoundException {

		HashMap<String, Object> response = new HashMap<>();

		response.put("Organization appointments", appointmentService.findAllByOrg(orgId));
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}
	
	@GetMapping("/{orgId}/{name}")
	public ResponseEntity<HashMap<String, Object>> allByEvent(@PathVariable Long orgId,@PathVariable String name) throws NotFoundException {

		HashMap<String, Object> response = new HashMap<>();

		response.put("Organization appointments", appointmentService.findByEvent(orgId,name));
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}
	

	@GetMapping("/{orgId}/actives")
	public ResponseEntity<HashMap<String, Object>> allActives(@PathVariable Long orgId) throws NotFoundException {

		HashMap<String, Object> response = new HashMap<>();

		response.put("Organization active appointments", appointmentService.findByIsActive(orgId));
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/new")
	public ResponseEntity<Appointment> setTurno(@RequestBody @Valid AppointmentDto appointment) throws AlreadyExistException {
		Appointment newAppointment = appointmentService.save(appointment);

		return ResponseEntity.ok().body(newAppointment);
	}

}
