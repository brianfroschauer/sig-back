package com.example.sigback.repository;

import com.example.sigback.entity.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandRepository extends JpaRepository<Stand, Long> {

    Optional<Stand> findFirstByRackIdAndIsFullIsFalse(Long rackId);
}
