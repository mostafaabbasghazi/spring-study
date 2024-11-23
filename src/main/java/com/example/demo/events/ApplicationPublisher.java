package com.example.demo.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPublisher {
    private final ApplicationEventPublisher applicationPublisher;

    public ApplicationPublisher(ApplicationEventPublisher applicationPublisher) {
        this.applicationPublisher = applicationPublisher;
    }
    public void publishEvent(String message) {
        Event event=new Event(this,message);
        applicationPublisher.publishEvent(event);

    }
}
