package com.informatorio.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.OrganizationDto;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.repository.IOrgDao;
import com.informatorio.app.wrapper.OrganizationWrapper;

@Service
public class OrgServiceImpl implements IOrgService {

	@Autowired
	IOrgDao orgDao;

	@Override
	public List<OrganizationDto> findByIsActiveTrue() {
		List<Organization> org = orgDao.findByIsActiveTrue();
		
		List<OrganizationDto> orgDto = org.stream()
				.map(x -> OrganizationWrapper.entityToDto(x))
				.collect(Collectors.toList());
		
		
		return orgDto;
	}

	@Override
	public List<OrganizationDto> findByAll() {
		List<Organization> org = orgDao.findAll();
		
		List<OrganizationDto> orgDto = org.stream()
				.map(x -> OrganizationWrapper.entityToDto(x))
				.collect(Collectors.toList());
		
		
		return orgDto;


	}

	@Override
	public Organization save(Organization org) throws AlreadyExistException {
		if (orgDao.findByMail(org.getMail()) != null || orgDao.findByCuit(org.getCuit()) != null) {
			throw new AlreadyExistException("Organization already exist");
		}

		return orgDao.save(org);
	}

	@Override
	public OrganizationDto findByCuit(String cuit) throws NotFoundException {
		Organization org = orgDao.findByCuit(cuit);
		if (org == null) {
			throw new NotFoundException();
		}
		return OrganizationWrapper.entityToDto(org);

	}

	@Override
	public OrganizationDto findByName(String name) throws NotFoundException {
		Organization org = orgDao.findByName(name);
		if (org == null) {
			throw new NotFoundException();
		}

		return OrganizationWrapper.entityToDto(org);
	}

}
