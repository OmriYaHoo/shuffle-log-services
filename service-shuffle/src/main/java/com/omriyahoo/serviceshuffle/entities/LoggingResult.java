package com.omriyahoo.serviceshuffle.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoggingResult {

    private ShuffledList shuffledList;
    private ShuffledNumber shuffledNumber;

}
