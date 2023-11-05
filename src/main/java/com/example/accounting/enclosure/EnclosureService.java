package com.example.accounting.enclosure;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnclosureService {
    private final EnclosureRepository repository;

    public EnclosureService(EnclosureRepository repository) {
        this.repository = repository;
    }

    public List<EnclosureDto> findAll() {
        return repository.findAll()
                .stream()
                .map(Enclosure::toDto)
                .collect(Collectors.toList());
    }

    public EnclosureDto create(EnclosureDto enclosureDto) {
        Enclosure enclosure = Enclosure.builder()
                .name(enclosureDto.getName())
                .qty(enclosureDto.getQty())
                .build();
        return repository.save(enclosure).toDto();
    }


    @Transactional
    public EnclosureDto update(EnclosureDto enclosureDto) {
        Optional<Enclosure> optionalEnclosure = repository.findById(enclosureDto.getId());
        if (optionalEnclosure.isPresent()) {
            Enclosure enclosure = optionalEnclosure.get();
            enclosure.setName(enclosureDto.getName());
            enclosure.setQty(enclosureDto.getQty());
            return repository.save(enclosure).toDto();
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
