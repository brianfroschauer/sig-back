package com.example.sigback.dto;

import com.example.sigback.entity.OrderState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * Author: brianfroschauer
 * Date: 25/10/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private float price;
    private OrderState state;
    private LocalDate createdDate;
    private SupplierDTO supplier;
    private Set<OrderItemDTO> items;
}
