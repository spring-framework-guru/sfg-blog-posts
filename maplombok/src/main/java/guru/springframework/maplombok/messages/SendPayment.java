package guru.springframework.maplombok.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendPayment {
    private UUID paymentId;
    private UUID payeeId;
    private String payoutMemo;
    private Long amount;
    private String payeeFirstName;
    private String payeeLastName;
    private String payeeAddressLine1;
    private String payeeAddressCity;
    private String payeeAddressStateOrProv;
    private String payeeAddressZipOrPostal;
    private String payeeAddressCountryCode;
    private String routingNumber;
    private String accountNumber;
    private String accountName;
}
