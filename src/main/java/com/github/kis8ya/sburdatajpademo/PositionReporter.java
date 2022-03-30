package com.github.kis8ya.sburdatajpademo;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Poller;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

@Configuration
@AllArgsConstructor
public class PositionReporter {

    private final PlaneFinderService planeFinderService;

    @Bean
    Supplier<Iterable<Aircraft>> reportPositions() {
        return () -> {
            System.out.println("Getting positions...");
            try {
                return planeFinderService.getAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Bad luck :(");
            return List.of();
        };
    }
}
