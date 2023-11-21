package com.example.accounting.enclosures;

import com.example.accounting.projects.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnclosureRepository extends JpaRepository<Enclosure, Long> {
    List<Enclosure> findByProject(Project project);
}
