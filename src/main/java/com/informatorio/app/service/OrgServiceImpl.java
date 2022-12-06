package com.informatorio.app.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.OrganizationDto;
import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.repository.IEventDao;
import com.informatorio.app.repository.IOrgDao;
import com.informatorio.app.wrapper.EventWrapper;
import com.informatorio.app.wrapper.OrganizationWrapper;

@Service
public class OrgServiceImpl implements IOrgService {

	@Autowired
	IOrgDao orgDao;
	@Autowired
	IEventDao eventDao;

	@Override
	public List<OrganizationDto> findByIsActiveTrue() {
		List<Organization> org = orgDao.findByIsActiveTrue();
		
		List<OrganizationDto> orgDto = org.stream()
				.map(x -> OrganizationWrapper.entityToDto(x))
				.collect(Collectors.toList());
		
		
		return orgDto;
	}

	@Override
	public List<Organization> findByAll() {
		List<Organization> org = orgDao.findAll();
		
//		List<OrganizationDto> orgDto = org.stream()
//				.map(x -> OrganizationWrapper.entityToDto(x))
//				.collect(Collectors.toList());
		
		
		return org;


	}

	@Override
	public OrganizationDto create(OrganizationDto orgDto) throws AlreadyExistException {
		if (orgDao.findByMail(orgDto.getMail()) != null || orgDao.findByCuit(orgDto.getCuit()) != null) {
			throw new AlreadyExistException("Organization already exist");
		}
		Organization org = OrganizationWrapper.dtoToEntity(orgDto);

		 
		return OrganizationWrapper.entityToDto(orgDao.save(org));
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
	
	


	@Override
	public Organization findById(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		if (orgDao.findById(id).isEmpty()) {
			throw new NotFoundException();
		}
			
		return orgDao.findById(id).orElse(null);

	}
	
	@Override
	public OrganizationDto updateOrg(Long id, OrganizationDto orgDto) throws NotFoundException, AlreadyExistException {
		
		if (orgDao.findByMailAndId(orgDto.getMail(), id) == null) {
			throw new AlreadyExistException("This email belongs to another Organization");
		} 
		
		Organization org = orgDao.findById(id).orElse(null);	
		
		if(org == null) {
			throw new NotFoundException();
		}
		
		org.setAddress(orgDto.getAddress());
		org.setName(orgDto.getName());
		org.setMail(orgDto.getMail());
		org.setPhone(orgDto.getPhone());
		
		if (orgDto.getPassword() != null) {
			
			org.setPassword(orgDto.getPassword());
		}

		return OrganizationWrapper.entityToDto(orgDao.save(org));
		
		
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		if (orgDao.findById(id).isEmpty()) {
			throw new NotFoundException();
		}
			
			orgDao.deleteById(id);
	}


}
