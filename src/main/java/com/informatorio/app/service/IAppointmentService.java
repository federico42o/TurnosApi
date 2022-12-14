package com.informatorio.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.entity.Appointment;
import com.informatorio.app.exception.AlreadyExistException;

public interface IAppointmentService {
	
	Appointment save(AppointmentDto appointment) throws AlreadyExistException;
	
	

	void cancel(Long id) throws NotFoundException;




	List<AppointmentDto> findAllByOrg(Long id) throws NotFoundException;


	List<AppointmentDto> findByIsActive(Long id) throws NotFoundException;


	List<AppointmentDto> findByEvent(Long id, String name) throws NotFoundException;
}
