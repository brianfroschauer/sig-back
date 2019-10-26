package com.example.sigback.repository;

import com.example.sigback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
