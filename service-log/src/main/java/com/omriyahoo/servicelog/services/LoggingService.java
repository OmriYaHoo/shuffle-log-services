package com.omriyahoo.servicelog.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RefreshScope
@ConfigurationProperties(prefix = "logging-service")
public class LoggingService {

    /**
     * Base url for accessing the logging service
     */
    @Setter
    @Getter
    private String resultConfig;

    public String logRequest(Map<String, Object> stringObjectMap) {
        log.info("Logging result: {}", stringObjectMap);
        return resultConfig;
    }

}
