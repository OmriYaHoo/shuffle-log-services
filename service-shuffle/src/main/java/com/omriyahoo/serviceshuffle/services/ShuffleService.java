package com.omriyahoo.serviceshuffle.services;

import com.omriyahoo.serviceshuffle.entities.LoggingResult;
import com.omriyahoo.serviceshuffle.entities.ShuffledList;
import com.omriyahoo.serviceshuffle.entities.ShuffledNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ShuffleService {

    private final LogService logService;

    public List<Integer> createShuffleListFromNumber(ShuffledNumber shuffledNumber) {
        List<Integer> integers = IntStream.iterate(1, i -> i + 1)
                .limit(shuffledNumber.getNumber())
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(integers);


        logService.sendInfoToLogService(
                LoggingResult.builder()
                        .shuffledNumber(shuffledNumber)
                        .shuffledList(new ShuffledList(integers))
                        .build()
        );

        return integers;
    }

}
