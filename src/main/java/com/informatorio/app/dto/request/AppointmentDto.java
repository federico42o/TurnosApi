package com.informatorio.app.dto.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDto {
	
	
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;

	@DateTimeFormat(style = "hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date eventHour;
	

}
