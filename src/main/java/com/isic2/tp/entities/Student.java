package com.isic2.tp.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends User implements Serializable {
	
	private String firstName;
	private String lastName;
	@ManyToOne
	private Filiere filiere;
	
	
	
	public Student() {
		super();
	}



	public Student(String firstName, String lastName, Filiere filiere) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.filiere = filiere;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Filiere getFiliere() {
		return filiere;
	}



	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
	
	

}
