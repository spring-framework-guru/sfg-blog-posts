package com.springframework.guru.service;


import com.springframework.guru.model.Product;
import java.util.List;

public interface ProductService {
     Product addProduct(Product product);
     Product getProduct(int id);
     List<Product> getAllProducts();


}
