package com.example.accounting.enclosureParts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewEnclosurePartDto {
    private Long partId;
    private double qty;
}
