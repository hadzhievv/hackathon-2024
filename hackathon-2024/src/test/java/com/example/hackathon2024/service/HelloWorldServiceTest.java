package com.example.hackathon2024.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloWorldServiceTest {

    @InjectMocks
    private HelloWorldService underTest;

    @Test
    void that_getHelloWorldMessage_returnsResult(){
        // Arrange
        var expectedResult = "Hello world!";

        // Act
        var actualResult = underTest.getHelloWorldMessage();

        // Assert
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }
}