package com.example.sigback.dto;

import com.example.sigback.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Author: brianfroschauer
 * Date: 26/10/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenasaDTO {

    private Long id;
    private int batch;
    private int amount;
    private String businessName;
    private String country;
    private LocalDate createdDate;
    private Product product;
}
