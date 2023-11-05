package com.example.accounting.part;

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
public class Part {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String reference;
    @Enumerated(EnumType.STRING)
    @Column(length = 75, nullable = false)
    private PartType partType;
    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MeasurementUnit unit;
    private String manufacturer;
}
