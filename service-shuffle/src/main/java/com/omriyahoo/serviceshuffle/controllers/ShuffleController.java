package com.omriyahoo.serviceshuffle.controllers;

import com.omriyahoo.serviceshuffle.entities.ShuffledList;
import com.omriyahoo.serviceshuffle.entities.ShuffledNumber;
import com.omriyahoo.serviceshuffle.services.ShuffleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/shuffle")
@RequiredArgsConstructor
public class ShuffleController {

    private final ShuffleService shuffleService;
    private final Environment environment;

    @PostMapping
    public ResponseEntity<ShuffledList> createShuffleList(@RequestBody @Valid ShuffledNumber shuffledNumber) {

        ShuffledList shuffledList = new ShuffledList(shuffleService.createShuffleListFromNumber(shuffledNumber));

        return ResponseEntity.ok(shuffledList);

    }

    @GetMapping
    public String environmentDetails() {
        return environment.toString();
    }

}
