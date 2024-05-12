package com.nps.demo;

import jakarta.persistence.DiscriminatorValue;
import lombok.Data;

@Data
@DiscriminatorValue(value = "3")
//@Entity
public class Instructor extends User{
    private double avrRating;
    private String specialization;
}
