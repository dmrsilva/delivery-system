package com.company.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.delivery.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
