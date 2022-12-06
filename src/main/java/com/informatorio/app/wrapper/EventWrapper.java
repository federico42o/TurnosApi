package com.informatorio.app.wrapper;

import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.dto.response.EventResponseDto;
import com.informatorio.app.entity.Event;

public class EventWrapper {

	public static Event dtoToEntity(EventDto dto) {
		if (dto == null)
			return new Event();

		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setLocation(dto.getLocation());
		entity.setIsUnique(dto.getIsUnique());
		entity.setEventDate(dto.getEventDate());
		

		return entity;
	}

	public static EventDto entityToDto(Event entity) {
		if (entity == null)
			return new EventDto();

		EventDto dto = new EventDto();
		dto.setName(entity.getName());
		dto.setLocation(entity.getLocation());
		dto.setIsUnique(entity.getIsUnique());
		dto.setEventDate(entity.getEventDate());
		dto.setOrganizationId(entity.getOrganization().getId());
		

		return dto;

	}
	public static EventResponseDto dtoToResponse(EventDto dto) {
		if (dto == null)
			return new EventResponseDto();

		EventResponseDto response = new EventResponseDto();
		response.setName(dto.getName());
		response.setLocation(dto.getLocation());
		response.setEventDate(dto.getEventDate());
		response.setOrganizationId(dto.getOrganizationId());
		

		return response;

	}
	
	
	
}
