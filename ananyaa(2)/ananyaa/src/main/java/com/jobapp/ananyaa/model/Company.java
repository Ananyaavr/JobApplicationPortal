// package com.jobapp.ananyaa.model;

// import java.util.List;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "companies")
// public class Company {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
//     private List<JobPosting> jobPostings;

//     @Column(name = "name")
//     private String name;

//     @Column(name = "description")
//     private String description;

//     @Column(name = "location")
//     private String location;
// }
