package com.project.moonbuddy.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "product")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name" ,nullable = false)
    private String name;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "release_date", nullable = false)
    private String release_date;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;
    @Column(name = "absortion", nullable = false)
    private double absortion;
    @Column(name = "humidity", nullable = false)
    private double humidity;
    @Column(name = "satisfaction", nullable = false)
    private double satisfaction;
    @Column(name = "safety", nullable = false)
    private double safety;
    @Column(name = "price", nullable = false)
    private double price;


}
