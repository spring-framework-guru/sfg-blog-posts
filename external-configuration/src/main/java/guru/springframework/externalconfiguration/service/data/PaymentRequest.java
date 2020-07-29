package guru.springframework.externalconfiguration.service.data;

import guru.springframework.externalconfiguration.config.MerchantAccount;
import lombok.Builder;
import lombok.Data;

/**
 * @author maureen on 28/7/2020
 */
@Data
@Builder
public class PaymentRequest {

    private String merchantCode;
    private double amount;
    private String customerAccount;
}
