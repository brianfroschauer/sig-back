package com.example.sigback.service;

import com.example.sigback.entity.Supplier;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface SupplierService {

    /**
     * Find the supplier with the provided id.
     *
     * @param id of the supplier to be found.
     * @return the supplier with the provided id.
     */
    Supplier findOne(Long id);

    /**
     * Find all suppliers.
     *
     * @return all suppliers or an empty list if there are no suppliers.
     */
    List<Supplier> findAll();

    /**
     * Create a new supplier.
     *
     * @param supplier to be created.
     * @return the created supplier.
     */
    Supplier create(Supplier supplier);

    /**
     * Update the supplier with the provided id.
     *
     * @param id of the supplier to be updated.
     * @param supplier the new supplier data.
     * @return the updated supplier.
     */
    Supplier update(Long id, Supplier supplier);

    /**
     * Delete the supplier with the provided id.
     *
     * @param id of the supplier to be deleted.
     */
    void delete(Long id);
}
