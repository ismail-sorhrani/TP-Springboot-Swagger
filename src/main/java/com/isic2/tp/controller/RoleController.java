package com.isic2.tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isic2.tp.entities.Role;
import com.isic2.tp.service.RoleService;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
	
	@Autowired
	RoleService service;
	
	@GetMapping
	public List<Role> findAllRoles(){
		return service.findAll();
	}
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		role.setId(0);
		return service.create(role);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Role role=service.findById(id);
		if(role==null) {
			return new ResponseEntity<Object>("role avec ID"+id+"nexist pas",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(role);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> upedateRole(@PathVariable int id,@RequestBody Role newrole){
		Role oldRole =service.findById(id);
		if(oldRole==null) {
			return new ResponseEntity<Object>("role avec Id"+id+"nexistpas",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(service.update(newrole));
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable int id){
		Role role =service.findById(id);
		if(role==null) {
			return new ResponseEntity<Object>("role avec Id"+id+"nexistpas",HttpStatus.BAD_REQUEST);
		}
		else {
			service.delete(role);
			return ResponseEntity.ok("Role supprime");
		}
		
	}
	
	

}
