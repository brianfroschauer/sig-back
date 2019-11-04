package com.example.sigback.service;

import com.example.sigback.entity.Claim;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
public interface ClaimService {

    /**
     *
     * @param claim
     * @return
     */
    Claim create(Claim claim);
}
