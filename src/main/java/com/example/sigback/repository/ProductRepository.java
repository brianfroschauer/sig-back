package com.example.sigback.repository;

import com.example.sigback.entity.OrderItem;
import com.example.sigback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from order_item where order_item.product_id in (select product.id from product where product.id in (select product_id from senasa where senasa.review_required = ?1))", nativeQuery = true)
    List<OrderItem> findQualityItems(boolean reviewRequired);
}
