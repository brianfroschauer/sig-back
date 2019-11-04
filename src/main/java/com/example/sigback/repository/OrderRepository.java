package com.example.sigback.repository;

import com.example.sigback.entity.Order;
import com.example.sigback.entity.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByState(OrderState state);
}
