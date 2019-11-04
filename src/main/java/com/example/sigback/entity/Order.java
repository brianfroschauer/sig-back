package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: brianfroschauer
 * Date: 25/10/2019
 */
@Data
@NoArgsConstructor
@Entity(name = "purchase_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private float price;

    @Column(name = "state")
    private OrderState state = OrderState.COMING;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Set<OrderItem> items = new HashSet<>();
}
