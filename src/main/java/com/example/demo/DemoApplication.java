package com.example.demo;

import org.hibernate.annotations.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Parent.class)
                .child(DemoApplication.class)
                .run(args);
    }

}
