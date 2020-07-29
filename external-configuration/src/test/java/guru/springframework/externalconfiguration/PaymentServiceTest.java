package guru.springframework.externalconfiguration;

import guru.springframework.externalconfiguration.service.data.PaymentRequest;
import guru.springframework.externalconfiguration.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void shouldInitiatePaymentWhenMerchantWithCodeExists(){
        PaymentRequest paymentRequest =PaymentRequest
                .builder()
                .amount(100)
                .customerAccount("Momo2018Acc")
                .merchantCode("MCA1230")
                .build();
        assertThat(paymentService.initialisePayment(paymentRequest).isSuccess()).isTrue();
    }

    @Test
    public void shouldFailPaymentInitiationWhenMerchantCodeIsInvalid(){
        PaymentRequest paymentRequest =PaymentRequest
                .builder()
                .customerAccount("Momoe2018Acc")
                .merchantCode("MCA12388888")
                .build();
        assertThat(paymentService.initialisePayment(paymentRequest).isSuccess()).isFalse();
    }
}
