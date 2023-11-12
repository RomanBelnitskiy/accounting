package com.example.accounting.parts;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartController {
    private final PartService service;

    public PartController(PartService service) {
        this.service = service;
    }

    @GetMapping
    public List<Part> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Part save(@RequestBody Part part) {
        return service.save(part);
    }

    @PutMapping
    public Part update(@RequestBody Part part) {
        return service.save(part);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
