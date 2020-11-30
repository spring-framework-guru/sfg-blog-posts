package com.springframeworkguru.Controller;

import com.springframeworkguru.Exception.ProductAlreadyExistsException;
import com.springframeworkguru.Service.ProductService;
import com.springframeworkguru.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductAlreadyExistsException {
        Product saveProduct = productService.addProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<List<Product>>(
                (List <Product>) productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        return new ResponseEntity<>(productService.getProductByid(id),HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
        public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        Product deletedProduct = productService.deleteProductById(id);
        responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);

        return responseEntity;
   }

}
