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

import com.isic2.tp.entities.Filiere;
import com.isic2.tp.service.FiliereService;

@RestController
@RequestMapping("/api/v1/filiers")
public class FiliereController  {
	
	@Autowired
	private FiliereService service;
	
	@GetMapping
	public List<Filiere> findAllFilieres(){
		return service.findAll();
	}
	
	@PostMapping
	public Filiere createFiliere(@RequestBody Filiere filiere) {
		filiere.setId(0);
		return service.create(filiere);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object>  updateFiliere(@PathVariable int id,@RequestBody Filiere newfiliere) {
		Filiere oldfFiliere=service.findById(id);
		if(oldfFiliere == null) {
			return new ResponseEntity<Object>("Filier avec ID" + id+ "neexist pas",HttpStatus.BAD_REQUEST);
		}
		else {
			newfiliere.setId(id);
			return ResponseEntity.ok(service.update(newfiliere));
			
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFilier(@PathVariable int id){
		Filiere filiere=service.findById(id);
		if(filiere==null) {
			return new ResponseEntity<Object>("Filier avec ID"+id+"nexsist pas",HttpStatus.BAD_REQUEST);
		}
		else{
			service.delete(filiere);
			return ResponseEntity.ok("filière supprimée");
		}
		
	}
	@GetMapping("/{id}") 
	public ResponseEntity<Object> findById(@PathVariable int id){
		Filiere filiere =service.findById(id);
		if(filiere==null) {
			return new ResponseEntity<Object>("Filier avec ID"+id+"nexist pas",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(filiere);
		}
	}
	

}
