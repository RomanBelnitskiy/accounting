package com.example.accounting.projects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<ProjectDto> findAll() {
        return repository.findAll()
                .stream()
                .map(Project::toDto)
                .collect(Collectors.toList());
    }

    public ProjectDto create(ProjectDto projectDto) {
        Project project = Project.builder()
                .name(projectDto.getName())
                .build();

        return repository.save(project).toDto();
    }

    @Transactional
    public ProjectDto update(ProjectDto projectDto) {
        Optional<Project> optionalProject = repository.findById(projectDto.getId());
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setName(projectDto.getName());
            return repository.save(project).toDto();
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
