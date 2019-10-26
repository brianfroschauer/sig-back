package com.example.sigback.service.implementation;

import com.example.sigback.entity.Supplier;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.SupplierRepository;
import com.example.sigback.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Supplier> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Supplier create(Supplier supplier) {
        return repository
                .save(supplier);
    }

    @Override
    public Supplier update(Long id, Supplier supplier) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setBusinessName(supplier.getBusinessName());
                    old.setCuit(supplier.getCuit());
                    old.setName(supplier.getName());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Supplier supplier = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(supplier);
    }
}
