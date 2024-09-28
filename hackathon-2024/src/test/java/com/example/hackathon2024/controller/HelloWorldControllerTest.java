package com.example.hackathon2024.controller;

import com.example.hackathon2024.advice.GlobalExceptionHandler;
import com.example.hackathon2024.service.HelloWorldService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.hackathon2024.configuration.WebPath.API_VERSION_1;
import static com.example.hackathon2024.configuration.WebPath.PATH_HELLO_WORLD;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
class HelloWorldControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private HelloWorldController underTest;
    @Mock
    private HelloWorldService mockCustomerService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(underTest)
                .setControllerAdvice(new GlobalExceptionHandler())
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    void that_getHelloWorldMessage_returnsResult() throws Exception {
        //  Act
        var actualResult = mockMvc.perform(get(API_VERSION_1 + PATH_HELLO_WORLD)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        assertNotNull(actualResult);
        verify(mockCustomerService).getHelloWorldMessage();
    }
}