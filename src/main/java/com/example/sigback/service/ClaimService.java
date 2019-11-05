package com.example.sigback.service;

import com.example.sigback.entity.Claim;
import com.example.sigback.entity.Order;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
public interface ClaimService {

    /**
     * Find the claim with the provided id.
     *
     * @param id of the claim.
     * @return the claim.
     */
    Claim findOne(Long id);

    /**
     * Find all claims.
     *
     * @return all claims.
     */
    List<Claim> findAll();

    /**
     * Create a new claim.
     *
     * @param claim to be created.
     * @return the associated order.
     */
    Order create(Claim claim);

    /**
     * Delete a claim with the provided id.
     *
     * @param id of the claim to be deleted.
     */
    void delete(Long id);
}
