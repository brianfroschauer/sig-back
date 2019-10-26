package com.example.sigback.service;

import com.example.sigback.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public interface ProductService {

    /**
     * Find the product with the provided id.
     *
     * @param id of the product to be found.
     * @return the product with the provided id.
     */
    Product findOne(Long id);

    /**
     * Find all products.
     *
     * @return all products or an empty list if there are no products.
     */
    List<Product> findAll();

    /**
     * Create a new product.
     *
     * @param product to be created.
     * @return the created product.
     */
    Product create(Product product);

    /**
     * Update the product with the provided id.
     *
     * @param id of the product to be updated.
     * @param product the new product data.
     * @return the updated product.
     */
    Product update(Long id, Product product);

    /**
     * Delete the product with the provided id.
     *
     * @param id of the product to be deleted.
     */
    void delete(Long id);
}
