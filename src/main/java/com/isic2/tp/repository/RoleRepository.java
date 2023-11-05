package com.isic2.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isic2.tp.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
