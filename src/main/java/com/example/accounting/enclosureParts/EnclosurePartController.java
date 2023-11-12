package com.example.accounting.enclosureParts;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enclosures")
public class EnclosurePartController {
    private final EnclosurePartService service;

    public EnclosurePartController(EnclosurePartService service) {
        this.service = service;
    }

    @GetMapping("/{enclosureId}/parts")
    public List<EnclosurePartDto> findByEnclosure(@PathVariable Long enclosureId) {
        return service.findAllByEnclosure(enclosureId);
    }

    @PostMapping("/{enclosureId}/parts")
    public EnclosurePartDto create(@PathVariable Long enclosureId, @RequestBody NewEnclosurePartDto dto) {
        return service.create(enclosureId, dto);
    }

    @PutMapping("/{enclosureId}/parts")
    public EnclosurePartDto update(@PathVariable Long enclosureId, @RequestBody EnclosurePartDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{enclosureId}/parts/{id}")
    public void delete(@PathVariable Long enclosureId, @PathVariable Long id) {
        service.delete(id);
    }
}
