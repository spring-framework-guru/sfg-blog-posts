package service;

import com.springframework.model.Product;
import com.springframework.repository.ProductRepository;
import com.springframework.service.ProductServiceImpl;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @ExtendWith(MockitoExtension.class)
    @SpringBootTest
    public class ProductServiceCacheTest {

        @Mock
        private ProductRepository productRepository;
        @Autowired
        @InjectMocks
        private ProductServiceImpl productService;
        private Product product1;
        private Product product2;
        private List<Product> ProductList;

        @BeforeEach
        public void setUp() {
            ProductList = new ArrayList<>();
            product1 = new Product(1, "Bread",30);
            product2 = new Product(2, "Jam",120);
            ProductList.add(product1);
            ProductList.add(product2);
        }

        @AfterEach
        public void tearDown() {
            product1 = product2 = null;
            ProductList = null;
        }

        @Test
        void givenCallToGetAllProductsThenShouldReturnListOfAllProducts() {
            productService.addProduct(product1);
            productService.addProduct(product2);

            productService.getAllProducts();
            productService.getAllProducts();
            productService.getAllProducts();
            productService.getAllProducts();
            verify(productRepository, times(1)).findAll();
        }

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

        @Test
        void givenProductToDeleteThenShouldEvictCache() {

            productService.addProduct(product1);
            productService.addProduct(product2);

            productService.deleteProductById(1);
            productService.getAllProducts();
            productService.getAllProducts();
            productService.getAllProducts();
            productService.getAllProducts();

            verify(productRepository, times(1)).findAll();
        }

        @Test
        void givenProductToUpdateThenShouldEvictCache() {

            productService.addProduct(product1);
            productService.addProduct(product2);

            productService.updateProduct(product1);
            product1.setPName("Sample User");

            productService.getAllProducts();
            productService.getAllProducts();
            productService.getAllProducts();
            productService.getAllProducts();

            verify(productRepository, times(1)).findAll();
        }
    }
}