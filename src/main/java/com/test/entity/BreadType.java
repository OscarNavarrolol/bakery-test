package com.test.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bread_type")
public class BreadType {

    @Id
    @Column(name = "bread_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breadId;

    @Column(name = "bread_name")
    private String breadName;

    private double price;

    private double weight;

    @Column(name = "production_time")
    private int productionTime;

    @Column(name = "flour_id")
    private Long flourId;
}
