package com.informatorio.app.wrapper;

import com.informatorio.app.dto.UserDto;
import com.informatorio.app.entity.User;

public class UserWrapper {
	
	public static User dtoToEntity(UserDto dto) {
		if(dto == null) return new User();
		
		User entity = new User();
		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setDni(dto.getDni());
		return entity;
		
	}
	
	public static UserDto entityToDto(User entity) {
		
		
		if(entity == null) return new UserDto();
		
		UserDto dto = new UserDto();
		
		dto.setName(entity.getName());
		dto.setLastName(entity.getLastName());
		dto.setDni(entity.getDni());
		return dto;
		
		
	}

}
