package com.bytelabs.payment_service.service;

import com.bytelabs.payment_service.config.AsyncConfig;
import com.bytelabs.payment_service.db.Nodb;
import com.bytelabs.payment_service.dtos.PaymentSummeryDto;
import com.bytelabs.payment_service.dtos.PaymentSummeryResponseDto;
import com.bytelabs.payment_service.util.PaymentDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final AsyncConfig aSyncConfig;

    PaymentService(AsyncConfig aSyncConfig) {
        this.aSyncConfig = aSyncConfig;
        feedData();
    }

    private void feedData() {
        Nodb.createDb();
    }

    public List<PaymentDetails> getPaymentList() {
        return Nodb.getPaymentList();
    }

    public void createPayment(PaymentDetails paymentDetails) {
        Nodb.createPayment(paymentDetails);
    }

    public PaymentSummeryResponseDto getPaymentSummery(PaymentSummeryDto paymentSummeryDto) {
        List<PaymentDetails> paymentDetails = Nodb.getPaymentList();
        double amount = 0;

        for (PaymentDetails paymentDetail : paymentDetails) {
            if (paymentDetail.getPaymentType() == paymentSummeryDto.getPaymentType()
                    && paymentDetail.getUserId().equals(paymentSummeryDto.getUserId())) {
                amount += paymentDetail.getAmount();
            }
        }

        PaymentSummeryResponseDto paymentSummeryResponseDto = new PaymentSummeryResponseDto();
        paymentSummeryResponseDto.setPaymentType(paymentSummeryDto.getPaymentType());
        paymentSummeryResponseDto.setUserId(paymentSummeryDto.getUserId());
        paymentSummeryResponseDto.setTotalAmount(amount);

        aSyncConfig.executorService().submit(this::task);

        return paymentSummeryResponseDto;
    }

    private void task() {
        System.out.println("Starting task");
    }
}
