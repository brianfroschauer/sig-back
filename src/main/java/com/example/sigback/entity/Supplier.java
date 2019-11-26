package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Data
@NoArgsConstructor
@Entity(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "business_name")
    private String businessName;

    public Supplier(String name, String cuit, String businessName) {
        this.name = name;
        this.cuit = cuit;
        this.businessName = businessName;
    }
}
