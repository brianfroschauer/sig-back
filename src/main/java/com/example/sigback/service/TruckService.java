package com.example.sigback.service;

import com.example.sigback.entity.Truck;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface TruckService {

    /**
     * Find the truck with the provided id.
     *
     * @param id of the truck to be found.
     * @return the truck with the provided id.
     */
    Truck findOne(Long id);

    /**
     * Find all trucks.
     *
     * @return all trucks or an empty list if there are no trucks.
     */
    List<Truck> findAll();

    /**
     * Create a new truck.
     *
     * @param truck to be created.
     * @return the created truck.
     */
    Truck create(Truck truck);

    /**
     * Update the truck with the provided id.
     *
     * @param id of the truck to be updated.
     * @param truck the new truck data.
     * @return the updated truck.
     */
    Truck update(Long id, Truck truck);

    /**
     * Delete the truck with the provided id.
     *
     * @param id of the truck to be deleted.
     */
    void delete(Long id);
}
