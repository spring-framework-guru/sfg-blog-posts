package guru.springframework.multipledatasources.repository.card;

import guru.springframework.multipledatasources.model.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
