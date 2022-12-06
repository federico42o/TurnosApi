package com.informatorio.app.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class EventResponseDto {

	private String name;
	private String location;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	

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

	
	
}