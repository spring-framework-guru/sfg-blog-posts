package guru.springframework.maplombok.svb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * SVB ACH Transfer Object.
 *
 * See <a href="https://www.svb.com/developers/ach">SVB Documentation</a> for additional information.
 *
 * *** Property level comments are from SVB docs
 */
@Getter
@Setter
@Builder
public class AchTransferObject {

    /**
     * SVB bank account number originating the ACH transfer.
     * Only accounts that have been explicitly enabled for API access may be passed here.
     */
    @NotNull
    private String accountNumber;

    /**
     * Amount of money to transfer, specified in cents. Setting amount equal to zero will cause this to be a
     * pre-notification transaction.
     */
    @NotNull
    private Integer amount;

    /**
     * A unique ID indicating the batch this transfer was sent with. Can be used to reconcile with your SVB bank
     * statements. Will be null until the transfer reaches processing status
     */
    private String batchId;

    /**
     * ID of the counterparty resource used in place of receiver_* fields, if applicable.
     * Note that transfers created using the counterparty_id will not return the receiver_* fields.
     */
    private Integer counterpartyId;

    /**
     * Currency type to transfer. Currently supports only USD.
     */
    @Builder.Default
    private SvbCurrency currency = SvbCurrency.USD;

    /**
     * Direction of the transfer. Credit means to push money to the receiver’s account and debit means to
     * pull money from the receiver’s account.
     */
    @NotNull
    @Builder.Default
    private AchDirection direction = AchDirection.CREDIT;

    /**
     * Date when the transfer should take place. Defaults to tomorrow’s date.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate effectiveDate;

    /**
     * Uniquely identifies each ACH transfer object.
     */
    private String id;

    /**
     * Optional 15 digit alphanumeric string that can be used to pass data to the recipient bank.
     * Examples: an invoice number or transaction reference number.
     */
    private String memo;

    /**
     * Optional metadata to associate with the API resource.
     */
    private Object metadata;

    /**
     * Bank account number that is receiving the ACH transfer.
     */
    @NotNull
    private String receiverAccountNumber;

    /**
     * Type of bank account that is receiving the ACH transfer.
     */
    @Builder.Default
    @NotNull
    private AchAccountType receiverAccountType = AchAccountType.CHECKING;

    /**
     * Name of the holder of the receiving account.
     */
    @NotNull
    private String receiverName;

    /**
     * ABA routing number associated with the receiver_account_number.
     */
    @NotNull
    private String receiverRoutingNumber;

    /**
     * If the ACH transfer has been returned ("status": "failed"),
     * or the transaction was corrected ("status": "corrected"),
     * this field will be an object containing the NACHA return or correction code and description.
     * For corrections, this will also contain the corrected value.
     */
    @JsonProperty("return") //return is Java key word
    private String returnValue;

    /**
     * SEC code to be used for the ACH transfer. Consult your banker if you’re not sure which
     * is the correct value for your use case.
     */
    @Builder.Default //todo - review this value
    @NotNull
    private SecCode secCode = SecCode.PPD;

    /**
     * Indicates whether this is a same-day or standard transfer.
     */
    private AchService service;

    private AchStatus status ;

    /**
     * Not documented in SVB docs
     */
    private String type;

    /**
     * Not documented in SVB docs
     */
    private String url;
}





























