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
@Entity(name = "inal")
public class Inal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "rnpa")
    private long rnpa;

    @Column(name = "batch")
    private int batch;

    @Column(name = "amount")
    private int amount;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;
}
