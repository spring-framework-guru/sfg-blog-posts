package com.springframework.guru.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.springframework.guru.model.Product;
import com.springframework.guru.repository.ProductRepository;
import java.util.List;

@CacheConfig(cacheNames = "product")
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    public ProductServiceImpl() {
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Caching(evict = {@CacheEvict(value = "allproductcache", allEntries = true),
            @CacheEvict(value = "productcache", key = "#product.id")
    })
    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    @Cacheable(value = "productcache",key ="#id" )
    @Override
    public Product getProduct(int id) {

        System.out.println("Data is about to be retrieved from database ");
        Product retrievedProduct = null;
        retrievedProduct = productRepository.findById(id).get();
        System.out.println("Data retrieved from database");
        return retrievedProduct;
    }

    @Cacheable(value = "allproductcache")
    @Override
    public List<Product> getAllProducts() {

        System.out.println("Data is retrieved from database ");
        return (List<Product>) productRepository.findAll();
    }


}
