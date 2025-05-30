package com.ekzonpractice.cepassport.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String documents;

    public Project() {}

    public Project(String name, String status, String documents) {
        this.name = name;
        this.status = status;
        this.documents = documents;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDocuments() { return documents; }
    public void setDocuments(String documents) { this.documents = documents; }
}