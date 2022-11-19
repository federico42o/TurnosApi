package com.informatorio.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



//@Entity(name = "addresses")
/*
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_street", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="street_id"))
	private Set<StreetName> street;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_number", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="number_id"))
	private Set<StreetNumber> number;
	

	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="address_floor", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="floor_id"))
	private Set<Floor> floor;

	
	@ManyToOne
	@JoinColumn(name = "street_city")
	private City city;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_organization")
	private Organization organization;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, Set<StreetName> street, Set<StreetNumber> number, Set<Floor> floor, City city,
			Organization organization) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.floor = floor;
		this.city = city;
		this.organization = organization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<StreetName> getStreet() {
		return street;
	}

	public void setStreet(Set<StreetName> street) {
		this.street = street;
	}

	public Set<StreetNumber> getNumber() {
		return number;
	}

	public void setNumber(Set<StreetNumber> number) {
		this.number = number;
	}

	public Set<Floor> getFloor() {
		return floor;
	}

	public void setFloor(Set<Floor> floor) {
		this.floor = floor;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	
	
	
}
*/
