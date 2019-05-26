package guru.springframework.multipledatasources.repository.cardholder;

import guru.springframework.multipledatasources.model.cardholder.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maureen on 26/5/2019
 */
public interface CardHolderRepository extends JpaRepository<CardHolder, Long> {
}
