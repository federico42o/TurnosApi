package com.informatorio.app.dto.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.User;

public class AppointmentDto {
	
	
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;

	@DateTimeFormat(style = "hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date eventHour;
	
	@NotBlank(message = "The event name is required")
	private String eventName;
	
	//private User user;
	@NotBlank(message = "The user name is required")
	private String name;
	@NotBlank(message = "The user lastname is required")
	private String lastName;
	@NotBlank(message = "The user dni is required")
	private String dni;
	@NotBlank(message = "The organization name is required")
	private String orgName;

	public AppointmentDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}



}
