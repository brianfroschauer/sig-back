package com.example.sigback.service.implementation;

import com.example.sigback.entity.Product;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.ProductRepository;
import com.example.sigback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Product create(Product product) {
        return repository
                .save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setName(product.getName());
                    old.setUnit(product.getUnit());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Product product = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(product);
    }
}
