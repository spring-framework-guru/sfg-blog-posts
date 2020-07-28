package guru.springframework.externalconfiguration.service;

import guru.springframework.externalconfiguration.config.MerchantAccount;
import guru.springframework.externalconfiguration.service.data.PaymentRequest;
import guru.springframework.externalconfiguration.service.data.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final MerchantAccount merchantAccount;

    public PaymentServiceImpl(MerchantAccount merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    @Override
    public PaymentResponse initialisePayment(PaymentRequest request) {
        log.info("received a payment initiate request {} ", request);
        if(merchantAccount.getCode().equalsIgnoreCase(request.getMerchantCode())){
            log.info("initialising payment for {} using merchant account {}", request, merchantAccount);
            return PaymentResponse
                    .builder()
                    .success(true)
                    .merchantAccount(merchantAccount)
                    .reference(LocalDateTime.now()+request.getCustomerAccount())
                    .build();
        }
        log.error("failed to initiate payment due to an invalid merchant account code provided");
        return PaymentResponse
                .builder()
                .success(false)
                .message("Invalid merchant account code provided")
                .build();
    }
}
