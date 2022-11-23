package com.informatorio.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.EventDto;
import com.informatorio.app.dto.OrganizationDto;
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
	public List<OrganizationDto> findByAll() {
		List<Organization> org = orgDao.findAll();
		
		List<OrganizationDto> orgDto = org.stream()
				.map(x -> OrganizationWrapper.entityToDto(x))
				.collect(Collectors.toList());
		
		
		return orgDto;


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
		if (orgDao.findById(id) != null) {
			return orgDao.findById(id).orElse(null);
		}else {
			
			throw new NotFoundException();
		}
	}

	@Override
	public void delete(Long id) {
		
		orgDao.deleteById(id);
	}


}
