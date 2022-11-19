package com.informatorio.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.app.dto.OrganizationDto;
import com.informatorio.app.entity.Organization;


@Repository
public interface IOrgDao extends JpaRepository<Organization, Long>{
	
	
	List<Organization> findByIsActiveTrue();

	Organization findByCuit(String cuit);
	Organization findByName(String name);
	Organization findByMail(String email);

}
