package com.nps.demo;

import jakarta.persistence.DiscriminatorValue;
import lombok.Data;

@Data
@DiscriminatorValue(value = "1")
//@Entity
public class Mentor extends User {
    private double avgRating;
    private String comp;
}
