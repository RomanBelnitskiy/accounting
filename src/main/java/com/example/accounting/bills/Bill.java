package com.example.accounting.bills;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private String supplier;
    private String number;
    private LocalDate date;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private boolean noticed;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus shipmentStatus;
    private String waybill;
    private String target;
    private String equipment;
    private String comment;
}
