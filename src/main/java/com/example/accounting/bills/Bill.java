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

    public BillDto toDto() {
        return BillDto.builder()
                .id(id)
                .supplier(supplier)
                .number(number)
                .date(date)
                .paymentStatus(paymentStatus)
                .noticed(noticed)
                .shipmentStatus(shipmentStatus)
                .waybill(waybill)
                .target(target)
                .equipment(equipment)
                .comment(comment)
                .build();
    }

    public static Bill toEntity(BillDto billDto) {
        return Bill.builder()
                .id(billDto.getId())
                .supplier(billDto.getSupplier())
                .number(billDto.getNumber())
                .date(billDto.getDate())
                .paymentStatus(billDto.getPaymentStatus())
                .noticed(billDto.isNoticed())
                .shipmentStatus(billDto.getShipmentStatus())
                .waybill(billDto.getWaybill())
                .target(billDto.getTarget())
                .equipment(billDto.getEquipment())
                .comment(billDto.getComment())
                .build();
    }
}
