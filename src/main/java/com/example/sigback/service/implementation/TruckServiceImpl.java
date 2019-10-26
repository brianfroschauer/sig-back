package com.example.sigback.service.implementation;

import com.example.sigback.entity.Truck;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.TruckRepository;
import com.example.sigback.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public class TruckServiceImpl implements TruckService {

    private final TruckRepository repository;

    @Autowired
    public TruckServiceImpl(TruckRepository repository) {
        this.repository = repository;
    }

    @Override
    public Truck findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Truck> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Truck create(Truck truck) {
        return repository
                .save(truck);
    }

    @Override
    public Truck update(Long id, Truck truck) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setBrand(truck.getBrand());
                    old.setDriver(truck.getDriver());
                    old.setEnrollment(truck.getEnrollment());
                    old.setModel(truck.getModel());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Truck truck = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(truck);
    }
}
