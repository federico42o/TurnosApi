package com.informatorio.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.app.dto.UserDto;
import com.informatorio.app.entity.User;

public interface IUserService {
	
	
	User create(UserDto user);
	List<User> findByAll();
	void delete(Long id) throws NotFoundException;
	

}
