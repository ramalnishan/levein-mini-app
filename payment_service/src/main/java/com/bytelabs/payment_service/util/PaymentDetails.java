package com.bytelabs.payment_service.util;

import com.bytelabs.payment_service.enums.PaymentStatus;
import com.bytelabs.payment_service.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class PaymentDetails {
    private String paymentId;
    private String userId;
    private String orderId;
    private double amount;
    private PaymentType paymentType;
    private LocalDateTime createdAt;
    private PaymentStatus status;
}