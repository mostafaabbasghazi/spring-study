package com.example.demo;

import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

@Profile("dev")
@RestController
@RequestMapping("/api")
public class Controllers {
    private final ApplicationAvailability availability;

    private final MessageSource messageSource;


    public Controllers(ApplicationAvailability availability, MessageSource messageSource) {
        this.availability = availability;
        this.messageSource = messageSource;
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)

    //@AssertTrue(message = "العمر يجب أن يكون أكبر من 18")

    @GetMapping(value = "/get", produces = { "application/json", "application/xml" })
    @Cacheable("users")
    //@CachePut(value = "users",key = "#user.id")
    //@CacheEvict(value = "users", key = "#userId")
//    @Caching(
//            evict = { @CacheEvict(value = "users", key = "#userId") },
//            put = { @CachePut(value = "users", key = "#userId") }
//    )

    public ResponseEntity<?> get() {
        DataSize dataSize = DataSize.ofGigabytes(2);
        Duration.ofSeconds(10);

        //return "Hello World " +availability.getLivenessState();
        return ResponseEntity.ok(Set.of("message", "Hello, World!"));

        //return messageSource.getMessage("greeting",new Object[] {"mostafa"}, LocaleContextHolder.getLocale());
    }

}
