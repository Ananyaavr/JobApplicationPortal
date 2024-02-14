package com.jobapp.ananyaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobapp.ananyaa.model.Application;

public interface ApplicationRepository extends JpaRepository<Application,String>{
    
}
