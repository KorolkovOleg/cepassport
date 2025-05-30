package com.ekzonpractice.cepassport.model;

public class ProjectDto {
    private String name;
    private String status;
    private String documents;

    // Конструкторы
    public ProjectDto() {}

    public ProjectDto(String name, String status, String documents) {
        this.name = name;
        this.status = status;
        this.documents = documents;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDocuments() { return documents; }
    public void setDocuments(String documents) { this.documents = documents; }
}
