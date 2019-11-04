package com.example.sigback.service.implementation;

import com.example.sigback.entity.Claim;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.ClaimRepository;
import com.example.sigback.service.ClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository repository;

    public ClaimServiceImpl(ClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public Claim findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Claim> findAll() {
        return repository.findAll();
    }

    @Override
    public Claim create(Claim claim) {
        return repository.save(claim);
    }

    @Override
    public void delete(Long id) {
        final Claim claim = findOne(id);
        repository.delete(claim);
    }
}
