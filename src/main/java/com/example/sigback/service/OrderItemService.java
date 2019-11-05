package com.example.sigback.service;

import com.example.sigback.entity.OrderItem;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 05/11/2019
 */
public interface OrderItemService {

    /**
     * Find all quality items.
     *
     * @return all quality items.
     */
    List<OrderItem> findValid();

    /**
     * Update the item with the provided id.
     *
     * @param id of the order item to be updated.
     * @param orderItem to be updated.
     * @return the update order.
     */
    OrderItem update(Long id, OrderItem orderItem);
}
