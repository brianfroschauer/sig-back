package com.example.sigback.repository;

import com.example.sigback.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query(value = "select * from order_item where order_item.product_id in (select product.id from product where product.id in (select senasa.product_id from senasa where senasa.review_required = ?1))", nativeQuery = true)
    List<OrderItem> findQualityOrderItems(boolean reviewRequired);
}
