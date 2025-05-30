package com.ekzonpractice.cepassport.controller;

import com.ekzonpractice.cepassport.model.Project;
import com.ekzonpractice.cepassport.model.ProjectDto;
import com.ekzonpractice.cepassport.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectDto projectDto) {
        Project project = new Project(
                projectDto.getName(),
                projectDto.getStatus(),
                projectDto.getDocuments()
        );
        return ResponseEntity.ok(service.createProject(project));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('READER','EDITOR')")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(service.getAllProjects());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('READER','EDITOR')")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = service.getProjectById(id);
        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyRole('READER','EDITOR')")
    public ResponseEntity<List<Project>> getProjectsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.getProjectsByStatus(status));
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('READER','EDITOR')")
    public ResponseEntity<List<Project>> searchProjectsByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchProjectsByName(name));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<?> updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectDto projectDto) {
        Project projectDetails = new Project(
                projectDto.getName(),
                projectDto.getStatus(),
                projectDto.getDocuments()
        );
        Project updatedProject = service.updateProject(id, projectDetails);
        return updatedProject != null ?
                ResponseEntity.ok(updatedProject) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}