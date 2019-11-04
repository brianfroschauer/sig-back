package com.example.sigback.service.implementation;

import com.example.sigback.entity.Claim;
import com.example.sigback.repository.ClaimRepository;
import com.example.sigback.service.ClaimService;
import org.springframework.stereotype.Service;

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
    public Claim create(Claim claim) {
        return repository.save(claim);
    }
}
