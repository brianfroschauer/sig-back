package com.example.sigback.dto;

import com.example.sigback.entity.ClaimType;
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
public class ClaimDTO {

    private Long id;
    private ClaimType type;
    private String title;
    private String message;
    private OrderDTO order;
}
