package com.example.sigback.service;

import com.example.sigback.entity.Inal;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public interface InalService {

    /**
     * Find the inal with the provided id.
     *
     * @param id of the inal to be found.
     * @return the inal with the provided id.
     */
    Inal findOne(Long id);

    /**
     * Find all inals.
     *
     * @return all inals or an empty list if there are no inals.
     */
    List<Inal> findAll();

    /**
     * Create a new inal.
     *
     * @param inal to be created.
     * @return the created inal.
     */
    Inal create(Inal inal);

    /**
     * Update the inal with the provided id.
     *
     * @param id of the inal to be updated.
     * @param inal the new inal data.
     * @return the updated inal.
     */
    Inal update(Long id, Inal inal);

    /**
     * Delete the inal with the provided id.
     *
     * @param id of the inal to be deleted.
     */
    void delete(Long id);
}
