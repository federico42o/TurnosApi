package com.informatorio.app.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.app.utils.RandomPasswordGenerator;


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
	private Boolean isActive = true;
	
	
	@OneToMany(mappedBy = "organization")
	@JsonIgnore
	private List<Address> addresses;
	
	
	@OneToMany(mappedBy = "organization")
	@JsonIgnore
	private List<Phone> phones;
	
	/*private String phone;*/
	@Column(unique = true)
	private String mail;
	
	@CreationTimestamp
	@Column(name ="created_at")
    @Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
	
	
	
	private String password;
	
	
	@PrePersist
	public void prePersist(){
		String pw = RandomPasswordGenerator.generate();
	    this.password = pw;
	}
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(Long id, String name, String cuit, Boolean isActive, List<Address> addresses,
			List<Phone> phones, String mail, Date createAt, String password) {
		this.id = id;
		this.name = name;
		this.cuit = cuit;
		this.isActive = isActive;
		this.addresses = addresses;
		this.phones = phones;
		this.mail = mail;
		this.createAt = createAt;
		this.password = password;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	
	
	
	



	
	
    
	

}
