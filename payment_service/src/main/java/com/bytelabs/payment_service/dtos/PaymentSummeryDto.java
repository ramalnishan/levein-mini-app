package com.bytelabs.payment_service.dtos;

import com.bytelabs.payment_service.enums.PaymentType;
import lombok.Getter;

@Getter
public class PaymentSummeryDto {
    private PaymentType paymentType;
    private String userId;
}
