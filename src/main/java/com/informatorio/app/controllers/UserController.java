package com.informatorio.app.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.app.dto.UserDto;
import com.informatorio.app.dto.request.EventDto;
import com.informatorio.app.dto.response.EventResponseDto;
import com.informatorio.app.entity.Event;
import com.informatorio.app.entity.User;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.BadRequestException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.service.IUserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	
	@GetMapping
	public ResponseEntity<HashMap<String, Object>> all() {
		HashMap<String, Object> response = new HashMap<>();
		List<User> all = userService.findByAll();

		response.put("usuarios", all);

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/new")
	public ResponseEntity<HashMap<String, Object>> createUser(@RequestBody @Valid UserDto userDto)
			throws AlreadyExistException, InvalidPasswordException, NotFoundException, BadRequestException {

		HashMap<String, Object> response = new HashMap<>();

		User newUser = userService.create(userDto);

		response.put("event", newUser);

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) throws NotFoundException{

		userService.delete(id);


	};


}
