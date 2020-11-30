package com.springframework.service;


import com.springframework.model.Product;
import com.springframework.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "product")
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;


    public ProductServiceImpl(){}

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository =productRepository;
    }

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

   @Caching(evict = { @CacheEvict(value = "allproductcache", allEntries = true),
            @CacheEvict(value = "productcache", key = "#product.id")
    })

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Cacheable(value = "productcache",key ="#id" )
    @Override
    public Product getProduct(int id) {
        System.out.println("Data retrieved from database\n");
        return productRepository.findById(id).orElse(null);
    }

    @Cacheable(value = "allproductcache")
   @Override
   public List<Product> getAllProducts() {
        System.out.println("Data retrieved from database\n");
        return (List<Product>) productRepository.findAll();
    }

   @Caching(evict = {
            @CacheEvict(value = "allproductcache", allEntries = true),
            @CacheEvict(value = "productcache", key = "#product.id")
    })
    @Override
    public Product deleteProductById(int id) {
       Product product = null;
       Optional optional = productRepository.findById(id);
       if (optional.isPresent()) {
           product = productRepository.findById(id).get();
           productRepository.deleteById(id);
       }
       System.out.println("Product deleted in database\n ");
       return product;
    }

    @CachePut(key = "#product.id")
    @Override
    public Product updateProduct(Product product){
         Product updateProduct = null;
       Optional optional = productRepository.findById(product.getId());
        if (optional.isPresent()){
            Product getProduct = productRepository.findById(product.getId()).get();
            getProduct.setPName(product.getPName());
            getProduct.setPrice(product.getPrice());
            updateProduct = addProduct(getProduct);
        }
        System.out.println("Product updated\n");
     return updateProduct;
    }
}
