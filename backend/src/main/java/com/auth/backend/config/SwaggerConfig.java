package com.auth.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi
                .builder()
                .group("auth-doc")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Authentication")
                        .version("1.0")
                        .description("API documentation for your Spring Boot Authentication System")
                );
    }
}
