package com.example.sigback.repository;

import com.example.sigback.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface TruckRepository extends JpaRepository<Truck, Long> {
}
