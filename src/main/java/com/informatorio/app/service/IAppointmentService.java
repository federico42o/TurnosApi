package com.informatorio.app.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.exception.AlreadyExistException;

public interface IAppointmentService {
	
	Appointment save(AppointmentDto appointment) throws AlreadyExistException;
	
	void cancel(Long id) throws NotFoundException;
}
