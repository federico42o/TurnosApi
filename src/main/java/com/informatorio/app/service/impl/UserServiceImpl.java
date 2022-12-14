package com.informatorio.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.UserDto;
import com.informatorio.app.entity.User;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.repository.IUserDao;
import com.informatorio.app.service.IUserService;
import com.informatorio.app.wrapper.UserWrapper;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	public User create(UserDto userDto) throws AlreadyExistException {

		User user = userDao.findByDni(userDto.getDni());
		if (user != null) {
			throw new AlreadyExistException("this DNI belongs to another person");
		}
		user = UserWrapper.dtoToEntity(userDto);
		return userDao.save(user);
	}

	@Override
	public List<User> findByAll() {

		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		if (userDao.findById(id).isEmpty()) {
			throw new NotFoundException();
		}

		userDao.deleteById(id);
	}

	@Override
	public User findByDni(String dni) throws NotFoundException {
		// TODO Auto-generated method stub
		User user = userDao.findByDni(dni);
		if (user == null) {
			throw new NotFoundException();
		}
		return user;
	}

	@Override
	public List<User> findByLastName(String lastName) throws NotFoundException {
		// TODO Auto-generated method stub

		List<User> users = userDao.findByLastName(lastName);
		if (users.isEmpty()) {
			throw new NotFoundException();
		}
		return users;
	}

	@Transactional
	@Override
	public User update(Long id, UserDto dto) throws NotFoundException, AlreadyExistException, InvalidPasswordException {

		User user = userDao.findByDni(dto.getDni());

		if (!userDao.findById(id).isPresent()) {
			throw new NotFoundException();
		}

		if (!dto.getPassword().equals(user.getPassword())) {

			throw new InvalidPasswordException("Invalid Password");
		} else {
			user.setName(dto.getName());
			user.setLastName(dto.getLastName());
		}

		return userDao.save(user);

	}

}
