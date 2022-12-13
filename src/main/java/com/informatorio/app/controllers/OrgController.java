package com.informatorio.app.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.informatorio.app.dto.OrganizationDto;
import com.informatorio.app.entity.Organization;
import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.InvalidPasswordException;
import com.informatorio.app.service.IOrgService;

@RestController
@RequestMapping("api/v1/organization")
public class OrgController {

	@Autowired
	private IOrgService orgService;

	@GetMapping
	public ResponseEntity<HashMap<String, Object>> all() {
		HashMap<String, Object> response = new HashMap<>();
		List<Organization> all = orgService.findByAll();

		response.put("organizaciones", all);

		return new  ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/actives")
	public ResponseEntity<HashMap<String, Object>> getActives() {
		HashMap<String, Object> response = new HashMap<>();
		List<OrganizationDto> org = orgService.findByIsActiveTrue();
		response.put("Organizaciones activas", org);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/actives/{cuit}")
	public ResponseEntity<HashMap<String, Object>> getByCuit(@PathVariable String cuit) throws NotFoundException {
		HashMap<String, Object> response = new HashMap<>();
		OrganizationDto org = orgService.findByCuit(cuit);
		response.put("Org", org);

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/actives/name/{name}")
	public ResponseEntity<HashMap<String, Object>> getByName(@PathVariable String name) throws NotFoundException {
		HashMap<String, Object> response = new HashMap<>();
		OrganizationDto org = orgService.findByName(name);
		response.put("Org", org);

		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/new")
	public ResponseEntity<OrganizationDto> createOrg(@RequestBody @Valid OrganizationDto orgDto)
			throws AlreadyExistException {
		// HashMap<String, Object> response = new HashMap<>();
		OrganizationDto newOrg = orgService.create(orgDto);
		// response.put("org", newOrg);

		// return new
		//return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.CREATED);
		return ResponseEntity.ok().body(newOrg);
	}

	@PutMapping("edit/{id}")
	public ResponseEntity<OrganizationDto> updateOrg(@PathVariable Long id, @RequestBody @Valid OrganizationDto orgDto)
			throws NotFoundException, AlreadyExistException {

		OrganizationDto updateOrg = orgService.updateOrg(id, orgDto);

		return ResponseEntity.ok().body(updateOrg);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id, @RequestBody Organization dto) throws NotFoundException, InvalidPasswordException {

		orgService.delete(id, dto);

		return new ResponseEntity<>(HttpStatus.OK);

	};

}
