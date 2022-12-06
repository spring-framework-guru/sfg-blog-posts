package guru.springframewok.jpaonetomany.bootstrap;

import guru.springframewok.jpaonetomany.model.Product;
import guru.springframewok.jpaonetomany.model.ShoppingCart;
import guru.springframewok.jpaonetomany.repositories.ShoppingCartRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {
    private ShoppingCartRepository shoppingCartRepository;
    public BootstrapData(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository=shoppingCartRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1=new Product("Luxor Pen","Perfect gift to your office colleague",new BigDecimal(88));
        Product product2=new Product("Wind of life","A best seller for self motivation",new BigDecimal(30));
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCartRepository.save(shoppingCart);
        loadData();
    }

    private void loadData() {
        Iterable<ShoppingCart> cart=shoppingCartRepository.findAll();
        for(ShoppingCart shoppingCartIterable: cart){
           shoppingCartIterable.getProducts().stream().forEach((items) -> {
                System.out.println(items.getName());
                System.out.println(items.getDescription());
                System.out.println(items.getPrice());
                System.out.println("_____________________");
            });
        }
    }
}
