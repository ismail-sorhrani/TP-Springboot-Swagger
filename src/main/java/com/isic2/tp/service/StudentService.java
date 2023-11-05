package com.isic2.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isic2.tp.dao.IDao;
import com.isic2.tp.entities.Filiere;
//import com.isic2.tp.entities.Role;
import com.isic2.tp.entities.Student;
import com.isic2.tp.repository.StudentRepository;

@Service
public class StudentService implements IDao<Student>{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Student create(Student o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Student o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Student update(Student o) {
		return repository.save(o);
	}

	@Override
	public Student findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}
	public List<Student> findByfilire(Filiere filiere){
		return repository.findByFiliere(filiere);
		
	}
//	public List<Student> findByRole(Role role){
//		return repository.findByRole(role);
//		
//	}
	

}
