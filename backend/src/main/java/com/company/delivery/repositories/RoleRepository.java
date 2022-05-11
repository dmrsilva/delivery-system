package com.company.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.delivery.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
