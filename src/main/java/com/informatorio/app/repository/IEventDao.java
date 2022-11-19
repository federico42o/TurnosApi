package com.informatorio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.app.entity.Event;


@Repository
public interface IEventDao extends JpaRepository<Event, Long>{

}
