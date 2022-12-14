package com.informatorio.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
	
	
	
	@NotBlank(message = "The NAME is required")
	@Size(min = 2,max = 20)
	private String name;
	@NotBlank(message = "The LASTNAME is required")
	@Size(min = 2,max = 20)
	private String lastName;
	@NotBlank(message = "The DNI is required")
	@Size(min = 8,max = 8, message = "The DNI must have only 8 characters")
	private String dni;
	
	private String password;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
