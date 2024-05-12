package com.nps.demo;

import jakarta.persistence.DiscriminatorValue;
import lombok.Data;

@Data
@DiscriminatorValue(value = "2")
//@Entity
public class TA extends User{
    private double avrRating;
    private int noOfSession;
}
