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
public class DriverDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private LocalDate licenseExpirationDate;
}
