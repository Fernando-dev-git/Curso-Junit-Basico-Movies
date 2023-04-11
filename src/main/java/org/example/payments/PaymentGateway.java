package org.example.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
