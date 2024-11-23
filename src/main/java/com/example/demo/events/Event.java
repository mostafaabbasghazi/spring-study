package com.example.demo.events;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class Event extends ApplicationEvent {
    private final String message;
    public Event(Object source,String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
