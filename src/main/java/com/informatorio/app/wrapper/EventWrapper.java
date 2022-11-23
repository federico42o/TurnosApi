package com.informatorio.app.wrapper;

import com.informatorio.app.dto.EventDto;

import com.informatorio.app.entity.Event;
public class EventWrapper {

	public static Event dtoToEntity(EventDto dto) {
		if (dto == null)
			return new Event();

		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setLocation(dto.getLocation());
		entity.setEventType(dto.getEventType());
		entity.setEventDate(dto.getEventDate());
		entity.setEventHour(dto.getEventHour());

		return entity;
	}

	public static EventDto entityToDto(Event entity) {
		if (entity == null)
			return new EventDto();

		EventDto dto = new EventDto();
		dto.setName(entity.getName());
		dto.setLocation(entity.getLocation());
		dto.setEventDate(entity.getEventDate());
		dto.setEventHour(entity.getEventHour());
		dto.setEventType(entity.getEventType());
		dto.setOrganization(entity.getOrganization().getId());

		return dto;

	}

}
