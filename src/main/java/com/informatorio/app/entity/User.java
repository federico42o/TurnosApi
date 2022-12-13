package com.informatorio.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.app.utils.RandomStringGenerator;

@Entity(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name ="last_name")
	private String lastName;
	
	


	@Column(unique = true)
	private String dni;
	
	
	@Column(name ="is_active")
	private Boolean isActive = true;
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Appointment> appointments =  new ArrayList<>();
	
	@PrePersist
	public void prePersist(){
		String pw = RandomStringGenerator.generate();
	    this.password = pw;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", isActive=" + isActive + ", password="
				+ password + "]";
	}
	
	
}
