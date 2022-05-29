package com.omriyahoo.serviceshuffle.entities;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class ShuffledNumber {

    @Min(1)
    @Max(1000)
    private int number;

}
