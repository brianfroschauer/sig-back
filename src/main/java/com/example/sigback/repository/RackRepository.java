package com.example.sigback.repository;

import com.example.sigback.entity.Rack;
import com.example.sigback.entity.RackType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RackRepository extends JpaRepository<Rack, Long> {

    Rack findFirstByType(RackType rackType);
}
