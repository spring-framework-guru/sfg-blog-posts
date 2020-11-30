package com.springframeworkguru.Service;

import com.springframeworkguru.Exception.ProductAlreadyExistsException;
import com.springframeworkguru.Repository.ProductRepository;
import com.springframeworkguru.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){

        this.productRepository =productRepository;
    }

    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistsException {
        if(productRepository.existsById(product.getId())){
            throw new ProductAlreadyExistsException();
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductByid(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product deleteProductById(int id) {
        Product product = null;
        Optional optional = productRepository.findById(id);
        if (optional.isPresent()) {
            product = productRepository.findById(id).get();
            productRepository.deleteById(id);
        }
        return product;
    }

}
