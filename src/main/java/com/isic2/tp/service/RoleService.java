package com.isic2.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isic2.tp.dao.IDao;
import com.isic2.tp.entities.Role;
import com.isic2.tp.repository.RoleRepository;

@Service
public class RoleService implements IDao<Role>{

	@Autowired
	private RoleRepository repository; 
	@Override
	public Role create(Role role) {
		return repository.save(role);
	}

	@Override
	public boolean delete(Role role) {
		try {
			repository.delete(role);
			return true;
		} catch (Exception e) {
			return false;
			
		}
		
	}

	@Override
	public Role update(Role role) {
		return repository.save(role);
	}

	@Override
	public Role findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	
}
