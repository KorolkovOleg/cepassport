package com.ekzonpractice.cepassport.service;

import com.ekzonpractice.cepassport.model.Project;
import com.ekzonpractice.cepassport.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project createProject(Project project) {
        return repository.save(project);
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Project getProjectById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Project> getProjectsByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Project> searchProjectsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = repository.findById(id).orElse(null);
        if (project != null) {
            project.setName(projectDetails.getName());
            project.setStatus(projectDetails.getStatus());
            project.setDocuments(projectDetails.getDocuments());
            return repository.save(project);
        }
        return null;
    }

    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}