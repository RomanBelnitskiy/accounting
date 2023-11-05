package com.example.accounting.enclosure;

import com.example.accounting.enclosurePart.EnclosurePart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Enclosure {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private double qty;
    @OneToMany(mappedBy = "enclosure")
    private Set<EnclosurePart> parts = new HashSet<>();

    public EnclosureDto toDto() {
        return new EnclosureDto(id, name, qty);
    }
}
