package com.ekzonpractice.cepassport.repository;


import com.ekzonpractice.cepassport.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByStatus(String status);
    List<Project> findByNameContainingIgnoreCase(String name);
}