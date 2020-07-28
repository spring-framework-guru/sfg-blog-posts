package guru.springframework.externalconfiguration.service.data;

import guru.springframework.externalconfiguration.config.MerchantAccount;
import lombok.Builder;
import lombok.Data;

/**
 * @author maureen on 28/7/2020
 */
@Data
@Builder
public class PaymentResponse {

    private boolean success;
    private String message;
    private MerchantAccount merchantAccount;
    private String reference;
}
