package com.springframework.controller;

import com.springframework.model.Product;
import com.springframework.service.ProductService;
import org.slf4j.Logger.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        Product deletedProduct = productService.deleteProductById(id);
        responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
        return responseEntity;
    }
    boolean deleteAProductById(@PathVariable() int id){
        productService.deleteProductById(id);
        return true;
    }

    @PutMapping("product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        //logger.info(".... Updating product Content of id: " + product.getId());
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

    }
}
