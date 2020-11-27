package java.com.product.restserviceforproduct.repository;


//import com.product.restserviceforproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.product.restserviceforproduct.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
