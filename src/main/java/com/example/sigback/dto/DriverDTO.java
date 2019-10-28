package com.example.sigback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Za-z]+")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z]+")
    private String lastName;
    private String dni;
    @Future
    private LocalDate licenseExpirationDate;
}
