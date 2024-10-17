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

    public Long getBreadId() {
        return breadId;
    }

    public void setBreadId(Long breadId) {
        this.breadId = breadId;
    }

    public String getBreadName() {
        return breadName;
    }

    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public Long getFlourId() {
        return flourId;
    }

    public void setFlourId(Long flourId) {
        this.flourId = flourId;
    }
}
