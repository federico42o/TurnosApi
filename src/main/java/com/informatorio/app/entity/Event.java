package com.informatorio.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "events")
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String location;
	
	@Column(name ="is_active")
	private Boolean isActive;
	
	@Column(name ="created_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
	
	@Column(name ="event_type")
	private Character eventType;
	

    @Temporal(TemporalType.TIME)
	private Date datetime;


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Event(Long id, String name, String location, Boolean isActive, Date createAt, Character eventType,
			Date datetime) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.isActive = isActive;
		this.createAt = createAt;
		this.eventType = eventType;
		this.datetime = datetime;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public Character getEventType() {
		return eventType;
	}


	public void setEventType(Character eventType) {
		this.eventType = eventType;
	}


	public Date getDatetime() {
		return datetime;
	}


	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
    
    

}
