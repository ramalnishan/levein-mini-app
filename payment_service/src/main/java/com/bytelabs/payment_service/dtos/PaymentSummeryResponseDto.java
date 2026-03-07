package com.bytelabs.payment_service.dtos;

import com.bytelabs.payment_service.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentSummeryResponseDto {
    private String userId;
    private PaymentType paymentType;
    private double totalAmount;
}
