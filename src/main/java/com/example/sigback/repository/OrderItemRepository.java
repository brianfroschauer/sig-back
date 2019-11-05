package com.example.sigback.repository;

import com.example.sigback.entity.OrderItem;
import com.example.sigback.entity.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query(value = "select * from order_item where order_item.order_id in (select purchase_order.id from purchase_order where purchase_order.state = 2)", nativeQuery = true)
    List<OrderItem> findOrderItemByOrderState(OrderState orderState);
}
