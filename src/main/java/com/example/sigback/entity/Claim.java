package com.example.sigback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: brianfroschauer
 * Date: 04/11/2019
 */
@Data
@NoArgsConstructor
@Entity(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private ClaimType type;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
