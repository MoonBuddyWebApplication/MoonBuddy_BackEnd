package com.project.moonbuddy.product.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String brand;
    private String release_date;
    private String info;
    private String picture;
    private double absorb;
    private double humidity;
    private double satisfaction;
    private double safety;
    private double price;

    @OneToMany(mappedBy = "product")
    private List<ProductIngredient> productIngredients = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductMark> productMarks = new ArrayList<>();
}
