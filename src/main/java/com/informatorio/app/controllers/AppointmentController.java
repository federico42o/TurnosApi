package com.informatorio.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.service.IAppointmentService;


@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
	
	
	@Autowired
	IAppointmentService appointmentService;
	
	@PostMapping("/new")
	public ResponseEntity<Appointment> setTurno(@RequestBody AppointmentDto appointment) throws AlreadyExistException{
		Appointment newAppointment = appointmentService.save(appointment);
		
		return ResponseEntity.ok().body(newAppointment);
	}

}
