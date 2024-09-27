package com.example.hackathon2024.configuration.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "springdoc.swagger-ui")
public final class SwaggerProperties {

    private final String serverUrl;

    private final SwaggerUIData properties;

    @Getter
    @AllArgsConstructor
    static class SwaggerUIData {
        private final String title;
        private final String description;
        private final String wikiUrl;
        private final String gitUrl;
    }
}
