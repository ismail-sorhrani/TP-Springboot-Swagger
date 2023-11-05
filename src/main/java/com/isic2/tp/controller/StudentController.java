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
import com.isic2.tp.entities.Student;
import com.isic2.tp.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping
	public List<Student> findAllStudent(){
		return service.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Student student =service.findById(id);
		if (student==null) {
			return new ResponseEntity<Object>("etudiant avec ID"+id+"existe pas",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(student);
		}
	}
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return service.create(student);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable int id,@RequestBody Student newstudent){
		Student oldStudent =service.findById(id);
		if(oldStudent==null) {
			return new ResponseEntity<Object>("etudiant avec ID"+id+"nexiste pas",HttpStatus.BAD_REQUEST);
			
		}
		else {
			return ResponseEntity.ok(service.update(newstudent));
		}
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable int id){
	Student student =service.findById(id);
	if(student==null) {
		return new ResponseEntity<Object>("etudiant avec ID"+id+"nexiste pas",HttpStatus.BAD_REQUEST);
		
	}
	else {
		return ResponseEntity.ok(service.delete(student));
	}
	}
	@GetMapping("/filiers")
	public List<Student> findByFiliere(@RequestBody Filiere filiere) {
		return service.findByfilire(filiere);
	}

}
