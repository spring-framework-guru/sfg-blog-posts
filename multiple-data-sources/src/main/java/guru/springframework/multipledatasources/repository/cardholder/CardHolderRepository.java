package guru.springframework.multipledatasources.repository.cardholder;

import guru.springframework.multipledatasources.model.cardholder.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHolderRepository extends JpaRepository<CardHolder, Long> {
}
