package com.example.accounting.enclosures;

import com.example.accounting.projects.Project;
import com.example.accounting.projects.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnclosureService {
    private final EnclosureRepository repository;
    private final ProjectRepository projectRepository;

    public EnclosureService(EnclosureRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    public List<EnclosureDto> findAll(Project project) {
        return repository.findByProject(project)
                .stream()
                .map(Enclosure::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public EnclosureDto create(EnclosureDto enclosureDto) {
        Project project = projectRepository.getReferenceById(enclosureDto.getProjectId());
        Enclosure enclosure = Enclosure.builder()
                .name(enclosureDto.getName())
                .qty(enclosureDto.getQty())
                .project(project)
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
