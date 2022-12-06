package guru.springframewok.jpaonetomany.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "shoppingCart",fetch = FetchType.EAGER)
    private Set<Product> products= new HashSet<>();

    public ShoppingCart addProduct(Product product){
        product.setShoppingCart(this);
        this.products.add(product);
        return this;
    }
}
