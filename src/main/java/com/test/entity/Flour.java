package com.test.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "flour")
public class Flour {

    @Id
    @Column(name = "flour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flourId;

    @Column(name = "flour_name")
    private String flourName;

    private Double quantity;

    private String unit;

    @Column(name = "last_restocked")
    private LocalDate lastRestocked;

    public Long getFlourId() {
        return flourId;
    }

    public void setFlourId(Long flourId) {
        this.flourId = flourId;
    }

    public String getFlourName() {
        return flourName;
    }

    public void setFlourName(String flourName) {
        this.flourName = flourName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDate getLastRestocked() {
        return lastRestocked;
    }

    public void setLastRestocked(LocalDate lastRestocked) {
        this.lastRestocked = lastRestocked;
    }
}
