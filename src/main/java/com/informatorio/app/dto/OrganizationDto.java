package com.informatorio.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationDto(String name, String cuit, String mail, String address, String phone) {
		this.name = name;
		this.cuit = cuit;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
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

}
