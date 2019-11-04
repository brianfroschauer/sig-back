package com.example.sigback.repository;

import com.example.sigback.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
