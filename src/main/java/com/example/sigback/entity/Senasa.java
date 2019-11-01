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
@Entity(name = "senasa")
public class Senasa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "batch")
    private int batch;

    @Column(name = "amount")
    private int amount;

    @Column(name = "review_required")
    private boolean reviewRequired;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "country")
    private String country;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
