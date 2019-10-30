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

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "country")
    private String country;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
