package com.informatorio.app.wrapper;

import com.informatorio.app.dto.request.AppointmentDto;
import com.informatorio.app.entity.Appointment;

public class AppointmentWrapper {
	
	public static Appointment dtoToEntity(AppointmentDto dto) {
		if (dto == null) return new Appointment();
		
		Appointment entity = new Appointment();
		entity.setEventDate(dto.getEventDate());
		entity.setEventHour(dto.getEventHour());
		
		
		return entity;
	}
	
	public static AppointmentDto entityToDto(Appointment entity) {
		if (entity == null) return new AppointmentDto();
		
		AppointmentDto dto = new AppointmentDto();
		dto.setEventDate(entity.getEventDate());
		dto.setEventHour(entity.getEventHour());

		return dto;
	}
}
