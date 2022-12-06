package com.informatorio.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.informatorio.app.entity.Event;

public class OrganizationDto {

	@NotBlank(message = "The name is required")
	private String name;

	@NotBlank(message = "The cuit is required")
	@Pattern(regexp = "\\b(30|33|34)(\\-)?[0-9]{8}(\\-)?[0-9]$", message = "The cuit format is invalid or does not belong to an organization")
	private String cuit;

	@NotBlank(message = "The email is required")
	@Email(message = "The email format is invalid")
	private String mail;

	private String address;

	@Pattern(regexp = "\\b\\d+\\b", message = "Thae phone number must be in a valid format")
	private String phone;
	

	private String password;
	

	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




}
