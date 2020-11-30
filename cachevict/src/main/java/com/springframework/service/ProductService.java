package com.springframework.service;

import com.springframework.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProduct(int id);
    List<Product> getAllProducts();
    Product deleteProductById(int id);
    Product updateProduct(Product product);



}
