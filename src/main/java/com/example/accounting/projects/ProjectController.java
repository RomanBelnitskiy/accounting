package com.example.accounting.projects;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProjectDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto projectDto) {
        return service.create(projectDto);
    }

    @PutMapping
    public ProjectDto update(@RequestBody ProjectDto projectDto) {
        return service.update(projectDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
