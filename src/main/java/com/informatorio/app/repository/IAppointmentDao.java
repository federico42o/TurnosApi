package com.informatorio.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.app.entity.Appointment;


@Repository
public interface IAppointmentDao extends JpaRepository<Appointment, Long>{

}
