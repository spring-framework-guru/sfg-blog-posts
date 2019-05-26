package guru.springframework.multipledatasources.repository.card;

import guru.springframework.multipledatasources.model.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maureen on 26/5/2019
 */
public interface CardRepository extends JpaRepository<Card, Long> {
}
