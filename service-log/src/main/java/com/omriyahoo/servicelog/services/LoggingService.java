package com.omriyahoo.servicelog.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class LoggingService {

    public void logRequest(Map<String, Object> stringObjectMap) {
        log.info("Logging result: {}", stringObjectMap);
    }

}
