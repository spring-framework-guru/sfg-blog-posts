package guru.springframewok.jpaonetomany.repositories;

import guru.springframewok.jpaonetomany.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long> {

}
