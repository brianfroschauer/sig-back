package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Data
@NoArgsConstructor
public class Remito {

    private LocalDate createdDate;
    private Supplier supplier;
    private Set<OrderItem> items;
}
