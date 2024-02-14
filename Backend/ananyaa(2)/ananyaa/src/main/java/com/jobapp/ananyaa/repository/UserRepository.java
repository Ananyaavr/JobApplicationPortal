package com.jobapp.ananyaa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobapp.ananyaa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByEmail(String email);

} 
