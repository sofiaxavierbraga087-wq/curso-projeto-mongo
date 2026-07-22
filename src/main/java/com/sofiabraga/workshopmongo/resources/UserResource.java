package com.sofiabraga.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofiabraga.workshopmongo.domain.User;
import com.sofiabraga.workshopmongo.dto.UserDTO;
import com.sofiabraga.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		
		List<User>list=service.findAll();
		
		List<UserDTO> listDTO=list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO>findById(@PathVariable String id){
		
		User obj= service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
		
	}
	
	
	
}
