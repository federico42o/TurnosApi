package com.informatorio.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.entity.Event;


@Repository
public interface IEventDao extends JpaRepository<Event, Long>{


	
	List<Event> findByLocation(String location);


	List<Event> findByName(String name);
	
	
	@Query(value="SELECT * 	from events u WHERE u.is_active = true and u.organization_id = ?1 and u.name = ?2", nativeQuery = true)
	List<Event> findByIsActiveAndByNameAndOrg(Long id, String name);
	


	EventDto save(EventDto entityToDto);

	
	

}
