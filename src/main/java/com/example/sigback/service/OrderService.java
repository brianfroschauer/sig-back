package com.example.sigback.service;

import com.example.sigback.entity.Order;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface OrderService {

    /**
     * Find the order with the provided id.
     *
     * @param id of the order to be found.
     * @return the order with the provided id.
     */
    Order findOne(Long id);

    /**
     * Find all orders.
     *
     * @return all orders or an empty list if there are no orders.
     */
    List<Order> findAll();

    /**
     * Create a new order.
     *
     * @param order to be created.
     * @return the created order.
     */
    Order create(Order order);

    /**
     * Update the order with the provided id.
     *
     * @param id of the order to be updated.
     * @param order the new order data.
     * @return the updated order.
     */
    Order update(Long id, Order order);

    /**
     * Delete the order with the provided id.
     *
     * @param id of the order to be deleted.
     */
    void delete(Long id);
}
