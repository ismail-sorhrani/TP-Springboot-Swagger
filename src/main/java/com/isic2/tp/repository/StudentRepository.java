package com.isic2.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isic2.tp.entities.Filiere;
//import com.isic2.tp.entities.Role;
import com.isic2.tp.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findByFiliere(Filiere filiere);
//	public List<Student> findByRole(Role role);
}
