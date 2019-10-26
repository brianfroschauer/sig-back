package com.example.sigback.service.implementation;

import com.example.sigback.entity.Driver;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.DriverRepository;
import com.example.sigback.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    @Autowired
    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Driver> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Driver create(Driver driver) {
        return repository
                .save(driver);
    }

    @Override
    public Driver update(Long id, Driver driver) {
        return repository
                .findById(id)
                .map(old -> {
                     old.setFirstName(driver.getFirstName());
                     old.setLastName(driver.getLastName());
                     old.setDni(driver.getDni());
                     old.setLicenseExpirationDate(driver.getLicenseExpirationDate());
                     return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Driver driver = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(driver);
    }
}
