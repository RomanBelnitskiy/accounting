package com.example.accounting.projects;

import com.example.accounting.enclosures.Enclosure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @CreationTimestamp
    private LocalDate createdAt;
    @OneToMany(mappedBy = "project")
    private List<Enclosure> enclosures = new ArrayList<>();

    public ProjectDto toDto() {
        return new ProjectDto(id, name, createdAt);
    }
}
