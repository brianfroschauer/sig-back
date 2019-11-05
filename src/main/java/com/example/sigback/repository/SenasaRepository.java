package com.example.sigback.repository;

import com.example.sigback.entity.Senasa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface SenasaRepository extends JpaRepository<Senasa, Long> {

    Optional<Senasa> findByProductId(Long productId);
}
