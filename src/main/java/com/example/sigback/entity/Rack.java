package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: brianfroschauer
 * Date: 05/11/2019
 */
@Data
@NoArgsConstructor
@Entity(name = "rack")
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
}
