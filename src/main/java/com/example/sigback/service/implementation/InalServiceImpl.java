package com.example.sigback.service.implementation;

import com.example.sigback.entity.Inal;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.InalRepository;
import com.example.sigback.service.InalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public class InalServiceImpl implements InalService {

    private final InalRepository repository;

    @Autowired
    public InalServiceImpl(InalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inal findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Inal> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Inal create(Inal inal) {
        inal.setCreatedDate(LocalDate.now());
        return repository
                .save(inal);
    }

    @Override
    public Inal update(Long id, Inal inal) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setRnpa(inal.getRnpa());
                    old.setBatch(inal.getBatch());
                    old.setProduct(inal.getProduct());
                    old.setDenomination(inal.getDenomination());
                    old.setBusinessName(inal.getBusinessName());
                    old.setExpirationDate(inal.getExpirationDate());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Inal inal = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(inal);
    }
}
