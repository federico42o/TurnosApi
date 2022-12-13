package com.informatorio.app.dto.request;

import java.util.Date;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDto {

	private String name;
	private String location;
	private Boolean isUnique;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	
	@DateTimeFormat(style = "hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm",timezone = "America/Argentina/Buenos_Aires")
	private Date eventHour;
	
	@NotBlank(message = "The password is required")
	private String password;

	private Long organizationId;

	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;

	}

	public Boolean getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getEventHour() {
		return eventHour;
	}

	public void setEventHour(Date eventHour) {
		this.eventHour = eventHour;
	}
	
	
}