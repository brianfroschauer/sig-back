package com.example.sigback.repository;

import com.example.sigback.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
