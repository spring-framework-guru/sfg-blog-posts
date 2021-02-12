package guru.springframework.maplombok.mappers;

import guru.springframework.maplombok.domain.Payment;
import guru.springframework.maplombok.messages.SendPayment;
import guru.springframework.maplombok.svb.model.AchTransferObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {

    Payment sendPaymentToPayment(SendPayment sendPayment);

    @Mapping(target = "id", ignore = true)
    AchTransferObject paymentToAchTransferObject(Payment payment);
}
