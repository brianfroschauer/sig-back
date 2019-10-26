package com.example.sigback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: brianfroschauer
 * Date: 25/10/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckDTO {

    private Long id;
    private String enrollment;
    private String brand;
    private String model;
    private DriverDTO driver;
}
