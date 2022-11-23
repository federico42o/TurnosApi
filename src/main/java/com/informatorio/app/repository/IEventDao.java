package com.informatorio.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.app.entity.Event;


@Repository
public interface IEventDao extends JpaRepository<Event, Long>{

	List<Event> findByEventDate(Date eventDate);
	
	List<Event> findByLocation(String location);

	List<Event> findByEventHour(Date eventDate);
	
	

}
