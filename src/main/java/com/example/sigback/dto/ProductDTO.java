package com.example.sigback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

/**
 * Author: brianfroschauer
 * Date: 25/10/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    @Pattern(regexp = "Kilogramos | Gramos | Toneladas | Litros | Mililitros")
    private String unit;
}
