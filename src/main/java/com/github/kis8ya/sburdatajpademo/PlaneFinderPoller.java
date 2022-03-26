package com.github.kis8ya.sburdatajpademo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class PlaneFinderPoller {

    private final WebClient webClient = WebClient.create("http://localhost:7634/aircraft");
    @NonNull
    private final AircraftRepository repository;

    @Scheduled(fixedRate = 3000)
    private void poll() {
        repository.deleteAll();

        webClient.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(aircraft -> !aircraft.getReg().isEmpty())
                .toStream()
                .forEach(repository::save);

        repository.findAll().forEach(System.out::println);
    }
}
