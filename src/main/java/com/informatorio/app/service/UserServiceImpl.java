package com.informatorio.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.app.dto.UserDto;
import com.informatorio.app.entity.User;
import com.informatorio.app.repository.IUserDao;
import com.informatorio.app.wrapper.UserWrapper;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDao userDao;

	@Override
	public User create(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = UserWrapper.dtoToEntity(userDto);
		return userDao.save(user);
	}

	@Override
	public List<User> findByAll() {
		
		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public void delete(Long id) throws NotFoundException{
		if (userDao.findById(id).isEmpty()) {
			throw new NotFoundException();
		}
			
		userDao.deleteById(id);
	}

}
