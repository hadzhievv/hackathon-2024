package com.example.hackathon2024.configuration.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConditionalOnProperty(value = "springdoc.api-docs.enabled", havingValue = "true")
@ConfigurationPropertiesScan("com.example.hackathon2024.configuration.swagger")
@AllArgsConstructor
public class SwaggerConfig {

    private static final String WIKI = "Wiki";
    private static final String GIT_REPOSITORY = "Git Repository";

    private final SwaggerProperties swaggerProperties;

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(getInfo())
                .servers(getServers())
                .externalDocs(getExternalDocs());
    }

    private Info getInfo() {
        return new Info()
                .title(swaggerProperties.getProperties().getTitle())
                .description(swaggerProperties.getProperties().getDescription())
                .contact(new Contact()
                        .name(WIKI)
                        .url(swaggerProperties.getProperties().getWikiUrl()));
    }

    private List<Server> getServers() {
        return List.of(new Server().url(swaggerProperties.getServerUrl()));
    }

    private ExternalDocumentation getExternalDocs() {
        return new ExternalDocumentation()
                .description(GIT_REPOSITORY)
                .url(swaggerProperties.getProperties().getGitUrl());
    }
}
