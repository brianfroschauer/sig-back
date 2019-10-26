package com.example.sigback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Author: brianfroschauer
 * Date: 25/10/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private LocalDate createdDate;
    private int amount;
    private float price;
    private ProductDTO product;
}
