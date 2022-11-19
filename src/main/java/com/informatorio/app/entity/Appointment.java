package com.informatorio.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "appointments")
public class Appointment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Temporal(TemporalType.TIME)
	private Date datetime;
    
    private String code;
    
	@Column(name ="is_active")
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "appointment_user")
	private User user;
	
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Appointment(Long id, Date datetime, String code, Boolean isActive, User user) {
		this.id = id;
		this.datetime = datetime;
		this.code = code;
		this.isActive = isActive;
		this.user = user;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDatetime() {
		return datetime;
	}



	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	
    
}
