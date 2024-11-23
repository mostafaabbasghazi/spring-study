package com.example.demo.events;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runnere implements CommandLineRunner {
    private final ApplicationPublisher eventPublisher;

    public Runnere(ApplicationPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void run(String... args) throws Exception {
        eventPublisher.publishEvent("ok ok ok ok ok ok");
    }
}
