package com.omriyahoo.serviceshuffle.services;

import com.omriyahoo.serviceshuffle.entities.LoggingResult;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@ConfigurationProperties(prefix = "logging-service")
public class LogService {

    /**
     * Base url for accessing the logging service
     */
    @Setter
    @Getter
    private String url;

    WebClient webClient = WebClient.create();

    public void sendInfoToLogService(LoggingResult currentRequest) {
        webClient.post()
                .uri(url+"/log")
                .body(Mono.just(currentRequest), LoggingResult.class)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();
    }

}
