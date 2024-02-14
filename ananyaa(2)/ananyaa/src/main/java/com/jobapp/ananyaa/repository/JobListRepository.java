package com.jobapp.ananyaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobapp.ananyaa.model.JobList;

@Repository
public interface JobListRepository extends JpaRepository<JobList, String> {
   
}