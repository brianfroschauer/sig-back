package com.example.sigback.repository;

import com.example.sigback.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
