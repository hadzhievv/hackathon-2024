package com.example.hackathon2024.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public static final String HELLO_WORLD = "Hello world!";

    public String getHelloWorldMessage() {
        return HELLO_WORLD;
    }
}
