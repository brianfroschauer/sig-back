package com.example.sigback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private ProductDTO product;
    private int quantity;
}
