package com.example.accounting.bills;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDto {
    private Long id;
    private String supplier;
    private String number;
    private LocalDate date;
    private BigDecimal total;
    private PaymentStatus paymentStatus;
    private boolean noticed;
    private ShipmentStatus shipmentStatus;
    private String waybill;
    private String target;
    private String equipment;
    private String comment;
}
