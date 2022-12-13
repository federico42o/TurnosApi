package com.informatorio.app.dto.response;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class EventResponseDto {

	private String name;
	private String location;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	@DateTimeFormat(style = "hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm",timezone = "America/Argentina/Buenos_Aires")
	private Date eventHour;
	private Long organizationId;

	public EventResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Date getEventHour() {
		return eventHour;
	}

	public void setEventHour(Date eventHour) {
		this.eventHour = eventHour;
	}

	
	
}