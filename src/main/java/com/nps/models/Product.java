package com.nps.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String image;

    @ManyToOne
    private Category category;
}

/*
1 ---------------> 1
Product ------ Category
   m<----------------- 1

   cardinality => m:1
 */
