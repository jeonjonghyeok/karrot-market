package com.numble.karrotmarket.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "API 명세서",
        description = "API 명세서",
        version = "v1"))
@SecurityScheme(
    name = "X-AUTH-TOKEN",
    type = SecuritySchemeType.APIKEY,
    scheme = "basic",
    in = SecuritySchemeIn.HEADER,
    bearerFormat = "JWT"
)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
            .group("API v1")
            .pathsToMatch(paths)
            .build();
    }
}