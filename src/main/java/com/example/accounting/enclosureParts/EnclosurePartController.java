package com.example.accounting.enclosureParts;

import com.example.accounting.enclosures.Enclosure;
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
    public List<EnclosurePartDto> findByEnclosure(@PathVariable(name = "enclosureId") Enclosure enclosure) {
        return service.findAllByEnclosure(enclosure);
    }

    @PostMapping("/{enclosureId}/parts")
    public EnclosurePartDto create(@PathVariable(name = "enclosureId") Enclosure enclosure,
                                   @RequestBody NewEnclosurePartDto dto) {
        return service.create(enclosure, dto);
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
