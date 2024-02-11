package com.werockstar.requestvalidationtesting;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class HelloController {

    @PostMapping
    public Response greeting(@Valid @RequestBody Request request) {
        return new Response("Hello, " + request.name());
    }

}

record Response(String message) {
}

record Request(@NotEmpty(message = "The name must be defined.") String name,
               @Positive(message = "Age should be positive") int age) {
}
