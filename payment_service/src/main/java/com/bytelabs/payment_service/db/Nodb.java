package com.bytelabs.payment_service.db;

import com.bytelabs.payment_service.enums.PaymentStatus;
import com.bytelabs.payment_service.enums.PaymentType;
import com.bytelabs.payment_service.util.PaymentDetails;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Nodb {
    public static List<PaymentDetails> paymentDetailsList = new ArrayList<>();

    private Nodb() {}

    public static void createDb() {
        paymentDetailsList.add(new PaymentDetails("PAY-1001", "USER-101", "ORDER-5001", 120.50, PaymentType.CARD, LocalDateTime.of(2024, 1, 10, 10, 15, 30), PaymentStatus.SUCCESS));
        paymentDetailsList.add(new PaymentDetails("PAY-1002", "USER-101", "ORDER-5002", 75.00, PaymentType.GOOGLE_PAY, LocalDateTime.of(2024, 1, 11, 11, 20, 45), PaymentStatus.FAILED));
        paymentDetailsList.add(new PaymentDetails("PAY-1003", "USER-101", "ORDER-5003", 250.99, PaymentType.APPLE_PAY, LocalDateTime.of(2024, 1, 12, 9, 5, 10), PaymentStatus.SUCCESS));

        paymentDetailsList.add(new PaymentDetails("PAY-1004", "USER-101", "ORDER-5004", 40.00, PaymentType.CARD, LocalDateTime.of(2024, 1, 13, 14, 30, 0), PaymentStatus.INITIATED));
        paymentDetailsList.add(new PaymentDetails("PAY-1005", "USER-101", "ORDER-5005", 60.00, PaymentType.CARD, LocalDateTime.of(2024, 1, 14, 16, 45, 20), PaymentStatus.SUCCESS));

        paymentDetailsList.add(new PaymentDetails("PAY-1006", "USER-102", "ORDER-5006", 310.00, PaymentType.CARD, LocalDateTime.of(2024, 1, 15, 12, 10, 55), PaymentStatus.FAILED));
        paymentDetailsList.add(new PaymentDetails("PAY-1007", "USER-102", "ORDER-5007", 15.75, PaymentType.APPLE_PAY, LocalDateTime.of(2024, 1, 16, 18, 5, 40), PaymentStatus.SUCCESS));

        paymentDetailsList.add(new PaymentDetails("PAY-1008", "USER-103", "ORDER-5008", 199.99, PaymentType.CARD, LocalDateTime.of(2024, 1, 17, 8, 55, 0), PaymentStatus.SUCCESS));
        paymentDetailsList.add(new PaymentDetails("PAY-1009", "USER-104", "ORDER-5009", 60.00, PaymentType.GOOGLE_PAY, LocalDateTime.of(2024, 1, 18, 13, 25, 35), PaymentStatus.INITIATED));
        paymentDetailsList.add(new PaymentDetails("PAY-1010", "USER-105", "ORDER-5010", 145.30, PaymentType.APPLE_PAY, LocalDateTime.of(2024, 1, 19, 17, 40, 10), PaymentStatus.SUCCESS));
    }

    public static List<PaymentDetails> getPaymentList() {
        return paymentDetailsList;
    }

    public static void createPayment(PaymentDetails paymentDetails) {
        paymentDetailsList.add(paymentDetails);
    }
}
