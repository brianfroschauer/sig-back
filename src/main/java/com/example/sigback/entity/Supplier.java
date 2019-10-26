package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Data
@NoArgsConstructor
@Entity(name = "supplier")
public class Supplier {

    @Column(name = "name")
    private String name;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "business_name")
    private String businessName;
}
