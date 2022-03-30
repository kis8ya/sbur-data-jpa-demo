package com.github.kis8ya.sburdatajpademo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneFinderService {

    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    public Iterable<Aircraft> getAll() throws IOException {
        System.out.println("data...");
        List<Aircraft> data = client.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(ac -> !ac.getReg().isEmpty())
                .toStream()
                .collect(Collectors.toList());
        return data;
    }
}

