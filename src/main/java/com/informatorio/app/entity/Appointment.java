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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.informatorio.app.utils.CheckDate;
import com.informatorio.app.utils.RandomStringGenerator;


@Entity(name = "appointments")
public class Appointment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	
    @Column(name = "code",nullable = true)
    private String code;
    
	@Column(name ="is_active")
	private Boolean isActive;
	
	@Column(name = "event_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;

//	@Column(name = "event_hour")
//	@Temporal(TemporalType.TIME)
//	private Date eventHour;
	
	@DateTimeFormat(style = "HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date eventHour;

//	@ManyToOne
//	@JoinColumn(name = "appointment_user")
//	private User user;
//	
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
	@PrePersist
	public void prePersist() {

		this.isActive = CheckDate.check(eventDate);
		this.code = RandomStringGenerator.generateCode();
	}
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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


//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}
	





	
    
}
