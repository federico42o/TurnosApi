package com.informatorio.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.app.dto.OrganizationDto;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;

public interface IOrgService {

	OrganizationDto findByCuit(String cuit) throws NotFoundException;

	OrganizationDto findByName(String name) throws NotFoundException;

	List<OrganizationDto> findByAll();

	List<OrganizationDto> findByIsActiveTrue();

	OrganizationDto create(OrganizationDto org) throws AlreadyExistException;

	Organization findById(Long id) throws NotFoundException;

	void delete(Long id);
}
