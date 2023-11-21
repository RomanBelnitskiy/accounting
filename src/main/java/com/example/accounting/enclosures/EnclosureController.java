package com.example.accounting.enclosures;

import com.example.accounting.projects.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enclosures")
public class EnclosureController {
    private final EnclosureService service;

    public EnclosureController(EnclosureService service) {
        this.service = service;
    }

    @GetMapping("/{projectId}")
    public List<EnclosureDto> findAll(@PathVariable(name = "projectId") Project project) {
        return service.findAll(project);
    }

    @PostMapping
    public EnclosureDto create(@RequestBody EnclosureDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public EnclosureDto update(@RequestBody EnclosureDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
