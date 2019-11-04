package com.example.sigback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemitoDTO {

    private LocalDate createdDate;
    private SupplierDTO supplier;
    private Set<OrderItemDTO> items;
}
