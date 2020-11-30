package com.springframeworkguru.Service;

import com.springframeworkguru.Exception.ProductAlreadyExistsException;
import com.springframeworkguru.model.Product;

import java.util.List;

public interface ProductService {

     Product addProduct(Product product) throws ProductAlreadyExistsException;
    List<Product> getAllProducts();
     Product getProductByid(int id);
    Product deleteProductById(int id);



}
