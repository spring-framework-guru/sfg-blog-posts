package com.springframework.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springframework.guru.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
