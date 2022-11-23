package com.informatorio.app.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDto {

	private String name;
	private String location;
	private String eventType;

	@NotBlank(message = "The password is required")
	private String password;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;

	@DateTimeFormat(style = "hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date eventHour;

	private Long organizationId;

	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDto(String name, String location, String eventType, Date eventDate, Date eventHour) {
		this.name = name;
		this.location = location;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventHour = eventHour;
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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganization(Long organization) {
		this.organizationId = organization;

	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getEventHour() {
		return eventHour;
	}

	public void setEventHour(Date eventHour) {
		this.eventHour = eventHour;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}