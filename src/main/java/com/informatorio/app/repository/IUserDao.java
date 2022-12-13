package com.informatorio.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.informatorio.app.entity.Organization;
import com.informatorio.app.entity.User;


@Repository
public interface IUserDao extends JpaRepository<User, Long>{
	
	@Query(value="SELECT * 	from users u WHERE u.name = ?1 and u.last_name = ?2 and u.dni = ?3", nativeQuery = true)
	User findByNameByLastNameByDni(String name,String lastname, String dni);
	
	@Query("SELECT u FROM users u WHERE u.dni = ?1 and u.id = ?2")
	User findByDniAndId(String mail, Long id);
	User findByDni(String dni);
}
