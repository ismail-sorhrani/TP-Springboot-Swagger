package com.isic2.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isic2.tp.dao.IDao;
import com.isic2.tp.entities.Filiere;
import com.isic2.tp.repository.FiliereRepository;

@Service
public class FiliereService implements IDao<Filiere> {
	@Autowired
	private FiliereRepository repository;

	@Override
	public Filiere create(Filiere filiere) {
		return repository.save(filiere);
	}

	@Override
	public boolean delete(Filiere filiere) {
		try {
			repository.delete(filiere);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Filiere update(Filiere filiere) {
		return repository.save(filiere);
	}

	@Override
	public Filiere findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Filiere> findAll() {
		return repository.findAll();
	}
	

}
