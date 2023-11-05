package com.example.accounting.enclosure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnclosureDto {
    private Long id;
    private String name;
    private double qty;
}
