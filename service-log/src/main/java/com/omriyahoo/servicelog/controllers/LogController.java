package com.omriyahoo.servicelog.controllers;

import com.omriyahoo.servicelog.services.LoggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {

    private final LoggingService loggingService;

    @PostMapping
    public ResponseEntity<String> printRequest(@RequestBody Map<String, Object> stringObjectMap) {
        String result = loggingService.logRequest(stringObjectMap);
        return ResponseEntity.ok("Logging request submitted and result config is " + result);
    }
}
