package com.omriyahoo.serviceshuffle.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;


@Data
public class ShuffledNumber {

    @Min(1)
    @Max(1000)
    private int number;

}
