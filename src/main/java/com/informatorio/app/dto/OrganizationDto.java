package com.informatorio.app.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



public class OrganizationDto {
	
	
	@NotBlank(message = "The name is required")
	private String name;
	
	
	
	@NotBlank(message = "The cuit is required")
	@Pattern(regexp = "\\b(30|33|34)(\\-)?[0-9]{8}(\\-)?[0-9]$", message = "The cuit format is invalid or does not belong to an organization")
	private String cuit;
	
	
	
	@NotBlank(message = "The email is required")
	@Email(message = "The email format is invalid")
	private String mail;
	
	public OrganizationDto(String name, String cuit, String mail) {
		this.name = name;
		this.cuit = cuit;
		this.mail = mail;
	}

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
	
	
	
	
}
