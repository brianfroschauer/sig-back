package com.example.sigback.dto;

import com.example.sigback.entity.OrderItemState;
import com.example.sigback.entity.Stand;
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

    private Long id;
    private ProductDTO product;
    private int quantity;
    private OrderItemState state;
    private Stand stand;
}
