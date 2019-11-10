package com.example.sigback.service;

import com.example.sigback.entity.Rack;

import java.util.List;

public interface RackService {

    /**
     * Find the rack with the provided id.
     *
     * @param id of the rack to be found.
     * @return the rack with the provided id.
     */
    Rack findOne(Long id);

    /**
     * Find all racks.
     *
     * @return all racks or an empty list if there are no racks.
     */
    List<Rack> findAll();

    /**
     * Create a new rack.
     *
     * @param rack to be created.
     * @return the created rack.
     */
    Rack create(Rack rack);

    /**
     * Delete the rack with the provided id.
     *
     * @param id of the rack to be deleted.
     */
    void delete(Long id);
}
