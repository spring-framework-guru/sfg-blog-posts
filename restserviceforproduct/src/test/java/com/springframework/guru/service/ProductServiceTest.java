package com.springframework.guru.service;

import com.springframework.guru.model.Product;
import com.springframework.guru.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Autowired
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;
    private List<Product> productList;

    @BeforeEach
    public void setUp() {
        productList = new ArrayList<>();
        product1 = new Product(1, "Bread", 20);
        product2 = new Product(2, "jam", 140);
        productList.add(product1);
        productList.add(product2);
    }

    @AfterEach
    public void tearDown() {
        product1 = product2 = null;
        productList = null;
    }

    //To return list of all products
    @Test
    void givenCallToGetAllUsersThenShouldReturnListOfAllProduct() {
        productService.addProduct(product1);
        productService.addProduct(product2);

        productService.getAllProducts();
        productService.getAllProducts();
        productService.getAllProducts();
        productService.getAllProducts();

        verify(productRepository, times(1)).findAll();
    }

    //to return product by id number
    @Test
    void givenProductIdThenShouldReturnProductWithThatId() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product1));
        productService.addProduct(product1);
        productService.addProduct(product2);

        productService.getProduct(product1.getId());
        productService.getProduct(product2.getId());

        verify(productRepository, times(1)).findById(product1.getId());
    }

    @Test
    void givenProductToSaveThenShouldEvictCache() {
        when(productRepository.save(any())).thenReturn(product1);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product1));
        productService.addProduct(product1);

        productService.getProduct(product1.getId());
        productService.getProduct(product1.getId());

        verify(productRepository, times(1)).findById(product1.getId());
    }

}