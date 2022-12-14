package com.informatorio.app.wrapper;



import com.informatorio.app.dto.OrganizationDto;
import com.informatorio.app.entity.Organization;

public class OrganizationWrapper {
	
	public static Organization dtoToEntity(OrganizationDto dto) {
		if (dto == null) return new Organization();
		
		Organization entity = new Organization();
		entity.setName(dto.getName());
		entity.setCuit(dto.getCuit());
		entity.setMail(dto.getMail());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		
		return entity;
	}
	
	public static OrganizationDto entityToDto(Organization entity) {
		if (entity == null) return new OrganizationDto();
		
		OrganizationDto dto = new OrganizationDto();
		dto.setName(entity.getName());
		dto.setCuit(entity.getCuit());
		dto.setMail(entity.getMail());
		dto.setAddress(entity.getAddress());
		dto.setPhone(entity.getPhone());
		dto.setPassword(entity.getPassword());

		return dto;
	}

	
}
