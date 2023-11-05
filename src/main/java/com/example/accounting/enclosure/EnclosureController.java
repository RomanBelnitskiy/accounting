package com.example.accounting.enclosure;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enclosures")
public class EnclosureController {
    private final EnclosureService service;

    public EnclosureController(EnclosureService service) {
        this.service = service;
    }

    @GetMapping
    public List<EnclosureDto> findAll() {
        return service.findAll();
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
