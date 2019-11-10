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
@Entity(name = "stand")
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(name = "z")
    private int z;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "amount")
    private int amount;

    @Column(name = "is_full")
    private boolean isFull;

    @ManyToOne
    private Rack rack;

    public Stand(int x, int y, int z, int capacity, Rack rack) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.capacity = capacity;
        this.rack = rack;
        this.isFull = false;
    }
}
