package com.example.sigback.service.implementation;

import com.example.sigback.entity.Senasa;
import com.example.sigback.exception.EntityNotFoundException;
import com.example.sigback.repository.SenasaRepository;
import com.example.sigback.service.SenasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public class SenasaServiceImpl implements SenasaService {

    private final SenasaRepository repository;

    @Autowired
    public SenasaServiceImpl(SenasaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Senasa findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Senasa> findAll() {
        return repository
                .findAll();
    }

    @Override
    public Senasa create(Senasa senasa) {
        senasa.setCreatedDate(LocalDate.now());
        return repository
                .save(senasa);
    }

    @Override
    public Senasa update(Long id, Senasa senasa) {
        return repository
                .findById(id)
                .map(old -> {
                    old.setBusinessName(senasa.getBusinessName());
                    old.setCertification(senasa.isCertification());
                    old.setCountry(senasa.getCountry());
                    return repository.save(old);
                })
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        final Senasa senasa = repository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(senasa);
    }
}
