package com.informatorio.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.app.dto.UserDto;
import com.informatorio.app.entity.User;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;

public interface IUserService {
	
	
	User create(UserDto user) throws AlreadyExistException;
	List<User> findByAll();
	void delete(Long id) throws NotFoundException;
	
	User findByDni(String dni) throws NotFoundException;
	
	User update(Long id, UserDto user) throws NotFoundException, AlreadyExistException, InvalidPasswordException;
	List<User> findByLastName(String lastName) throws NotFoundException;
}
