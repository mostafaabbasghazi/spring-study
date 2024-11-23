package com.example.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listner implements ApplicationListener<Event> {
    @Override
    //@EventListener
    public void onApplicationEvent(Event event) {

        System.out.println("Received custom event - " + event.getMessage());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
