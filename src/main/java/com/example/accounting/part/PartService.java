package com.example.accounting.part;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {
    private final PartRepository repository;

    public PartService(PartRepository repository) {
        this.repository = repository;
    }

    public List<Part> findAll() {
        return repository.findAll();
    }

    public Part save(Part part) {
        return repository.save(part);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
