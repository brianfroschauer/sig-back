package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Data
@NoArgsConstructor
@Entity(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return getQuantity() == orderItem.getQuantity() &&
                Objects.equals(getProduct(), orderItem.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getQuantity());
    }
}
