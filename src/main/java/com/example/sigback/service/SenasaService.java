package com.example.sigback.service;

import com.example.sigback.entity.Senasa;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public interface SenasaService {

    /**
     * Find the senasa with the provided id.
     *
     * @param id of the senasa to be found.
     * @return the senasa with the provided id.
     */
    Senasa findOne(Long id);

    /**
     * Find all senasas.
     *
     * @return all senasas or an empty list if there are no senasas.
     */
    List<Senasa> findAll();

    /**
     * Create a new senasa.
     *
     * @param senasa to be created.
     * @return the created senasa.
     */
    Senasa create(Senasa senasa);

    /**
     * Update the senasa with the provided id.
     *
     * @param id of the senasa to be updated.
     * @param senasa the new senasa data.
     * @return the updated senasa.
     */
    Senasa update(Long id, Senasa senasa);

    /**
     * Delete the senasa with the provided id.
     *
     * @param id of the senasa to be deleted.
     */
    void delete(Long id);
}
