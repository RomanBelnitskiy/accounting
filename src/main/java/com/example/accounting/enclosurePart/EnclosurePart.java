package com.example.accounting.enclosurePart;

import com.example.accounting.enclosure.Enclosure;
import com.example.accounting.part.Part;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "enclosure_part")
public class EnclosurePart {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "enclosure_id", nullable = false)
    private Enclosure enclosure;
    @ManyToOne
    @JoinColumn(name = "part_id", nullable = false)
    private Part part;
    private double qty;

    public EnclosurePartDto toDto() {
        return EnclosurePartDto.builder()
                .id(id)
                .name(part.getName())
                .reference(part.getReference())
                .qty(qty)
                .price(part.getPrice())
                .unit(part.getUnit())
                .build();
    }
}
