package com.example.accounting.enclosurePart;

import com.example.accounting.part.MeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnclosurePartDto {
    private Long id;
    private String name;
    private String reference;
    private double qty;
    private BigDecimal price;
    private MeasurementUnit unit;
}
