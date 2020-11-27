package java.com.product.restserviceforproduct.service;

//import com.product.restserviceforproduct.model.Product;

import java.com.product.restserviceforproduct.model.Product;
import java.util.List;

public interface ProductService {
     Product addProduct(Product product);
     Product getProduct(int id);
     List<Product> getAllProducts();


}
