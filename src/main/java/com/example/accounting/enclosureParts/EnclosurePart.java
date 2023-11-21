package com.example.accounting.enclosureParts;

import com.example.accounting.enclosures.Enclosure;
import com.example.accounting.parts.Part;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
                .unit(part.getUnit())
                .price(part.getPrice())
                .total(part.getPrice().multiply(BigDecimal.valueOf(qty)))
                .build();
    }
}
