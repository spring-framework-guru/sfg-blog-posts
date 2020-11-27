package com.springframewrk.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springframewrk.guru.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
