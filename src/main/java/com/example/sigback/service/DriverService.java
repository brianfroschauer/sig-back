package com.example.sigback.service;

import com.example.sigback.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Service
public interface DriverService {

    /**
     * Find the driver with the provided id.
     *
     * @param id of the driver to be found.
     * @return the driver with the provided id.
     */
    Driver findOne(Long id);

    /**
     * Find all drivers.
     *
     * @return all drivers or an empty list if there are no drivers.
     */
    List<Driver> findAll();

    /**
     * Create a new driver.
     *
     * @param driver to be created.
     * @return the created driver.
     */
    Driver create(Driver driver);

    /**
     * Update the driver with the provided id.
     *
     * @param id of the driver to be updated.
     * @param driver the new driver data.
     * @return the updated driver.
     */
    Driver update(Long id, Driver driver);

    /**
     * Delete the driver with the provided id.
     *
     * @param id of the driver to be deleted.
     */
    void delete(Long id);
}
