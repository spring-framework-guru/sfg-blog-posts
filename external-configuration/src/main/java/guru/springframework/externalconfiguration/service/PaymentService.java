package guru.springframework.externalconfiguration.service;

import guru.springframework.externalconfiguration.service.data.PaymentRequest;
import guru.springframework.externalconfiguration.service.data.PaymentResponse;

public interface PaymentService {

    PaymentResponse initialisePayment(PaymentRequest request);
}
