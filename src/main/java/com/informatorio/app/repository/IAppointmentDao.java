package com.informatorio.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.informatorio.app.entity.Appointment;



@Repository
public interface IAppointmentDao extends JpaRepository<Appointment, Long>{

	List<Appointment> findAllByOrganizationId(Long id);
	
	@Query(value="SELECT * FROM appointments u WHERE u.organization_id = ?1 and u.is_active = 1",nativeQuery = true)
	List<Appointment> findAllByOrgIdAndByIsActive(Long id);
	
	@Query(value="SELECT * FROM appointments u WHERE u.organization_id = ?1 and u.event_id = ?2",nativeQuery = true)
	List<Appointment> findByOrganizationAndByEvent(Long org_id,Long event_id);
}
