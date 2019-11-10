package com.example.sigback.service.implementation;

import com.example.sigback.entity.Rack;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.RackRepository;
import com.example.sigback.service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackServiceImpl implements RackService {

    private final RackRepository repository;

    @Autowired
    public RackServiceImpl(RackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rack findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Rack> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Rack create(Rack rack) {
        return repository
                .save(rack);
    }

    @Override
    public void delete(Long id) {
        final Rack rack = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(rack);
    }
}
