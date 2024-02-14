package com.jobapp.ananyaa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String applicationId;

    @Column(nullable=false)
    private String applicantName;

    @Column(nullable=false)
    private String applicantContact;

    @Column(nullable=false)
    private String workExperience;

    @Column(nullable=false)
    private String applicantEmail;

    @Column(nullable=false)
    private String applicantSkills;
    @Column(nullable=false)
    private String resumePath;
}
