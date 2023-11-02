package com.project.moonbuddy.product.dto.response;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ProductResponse {
    private long id;
    private String name;
    private String category;
    private String brand;
    private String release_date;
    private String description;
    private String picture;
    private double absorption;
    private double humidity;
    private double satisfaction;
    private  double safety;
    private double price;


}
