package com.bytelabs.payment_service.controller;

import com.bytelabs.payment_service.dtos.PaymentSummeryDto;
import com.bytelabs.payment_service.dtos.PaymentSummeryResponseDto;
import com.bytelabs.payment_service.service.PaymentService;
import com.bytelabs.payment_service.util.PaymentDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/summery")
    public ResponseEntity<PaymentSummeryResponseDto> paymentSummery(@RequestBody PaymentSummeryDto paymentSummeryDto) {
        PaymentSummeryResponseDto list = paymentService.getPaymentSummery(paymentSummeryDto);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public void createPayment(PaymentDetails paymentDetails) {
        paymentService.createPayment(paymentDetails);
    }

    @GetMapping
    public ResponseEntity<List<PaymentDetails>> getPaymentList() {
        List<PaymentDetails> list = paymentService.getPaymentList();
        return ResponseEntity.ok(list);
    }
}
