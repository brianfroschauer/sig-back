package com.example.sigback.repository;

import com.example.sigback.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
