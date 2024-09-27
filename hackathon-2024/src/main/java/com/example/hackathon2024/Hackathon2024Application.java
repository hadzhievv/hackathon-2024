package com.example.hackathon2024;

import com.example.hackathon2024.configuration.swagger.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class Hackathon2024Application {

    public static void main(String[] args) {
        SpringApplication.run(Hackathon2024Application.class, args);
    }

}
