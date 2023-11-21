package com.example.accounting.enclosureParts;

import com.example.accounting.enclosures.Enclosure;
import com.example.accounting.parts.PartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnclosurePartService {
    private final EnclosurePartRepository repository;
    private final PartRepository partRepository;

    public EnclosurePartService(EnclosurePartRepository repository,
                                PartRepository partRepository) {
        this.repository = repository;
        this.partRepository = partRepository;
    }

    @Transactional
    public EnclosurePartDto create(Enclosure enclosure, NewEnclosurePartDto newDto) {
        EnclosurePart enclosurePart = EnclosurePart
                .builder()
                .enclosure(enclosure)
                .part(partRepository.getReferenceById(newDto.getPartId()))
                .qty(newDto.getQty())
                .build();
        return repository.save(enclosurePart).toDto();
    }

    @Transactional
    public EnclosurePartDto update(EnclosurePartDto dto) {
        EnclosurePart enclosurePart = repository.findById(dto.getId()).get();
        enclosurePart.setQty(dto.getQty());
        return enclosurePart.toDto();
    }

    @Transactional
    public List<EnclosurePartDto> findAllByEnclosure(Enclosure enclosure) {
        return repository
                .findByEnclosure(enclosure)
                .stream()
                .map(EnclosurePart::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
