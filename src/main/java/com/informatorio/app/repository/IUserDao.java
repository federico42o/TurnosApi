package com.informatorio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.app.entity.User;


@Repository
public interface IUserDao extends JpaRepository<User, Long>{

}
