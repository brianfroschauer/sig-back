package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private float price;

    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;
}
