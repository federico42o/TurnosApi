package com.informatorio.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.app.utils.RandomStringGenerator;


@Entity(name = "organizations")
public class Organization implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String cuit;
	
	@Column(name ="is_active")
	private Boolean isActive;
	
	//normalizar
	private String address;
	
	//normalizar
	private String phone;
	
	/*private String phone;*/
	@Column(unique = true)
	private String mail;
	
	@Column(name ="created_at")
    @Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@CreationTimestamp
    private Date createdAt;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Event> events;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Appointment> appointments;
	
	
	@PrePersist
	public void prePersist(){
		String pw = RandomStringGenerator.generate();
	    this.password = pw;
	    this.isActive = true;
	    
	}
	public Organization() {
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
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	

	
	



	
	
    
	

}
