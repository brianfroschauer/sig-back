package com.example.sigback.dto;

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
public class InalDTO {

    private Long id;
    private String denomination;
    private long rnpa;
    private int batch;
    private String businessName;
    private LocalDate createdDate;
    private LocalDate expirationDate;
    private ProductDTO product;
}
