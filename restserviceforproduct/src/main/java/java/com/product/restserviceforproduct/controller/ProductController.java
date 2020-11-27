package java.com.product.restserviceforproduct.controller;

//import com.product.restserviceforproduct.model.Product;
//import com.product.restserviceforproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.com.product.restserviceforproduct.model.Product;
import java.com.product.restserviceforproduct.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/version1/")
public class ProductController {
    private ProductService productService;

    //private static final Logger logger = LoggerFactory.getL(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ResponseEntity<Product> saveAProduct(@RequestBody Product product){
    Product saveProduct = productService.addProduct(product);
    return new ResponseEntity<>(saveProduct,HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<List<Product>>(
                (List <Product>) productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product retrievedProduct = productService.getProduct(id);
        return new ResponseEntity<Product>(retrievedProduct, HttpStatus.OK);
    }


}
