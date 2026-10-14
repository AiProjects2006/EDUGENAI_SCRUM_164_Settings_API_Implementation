package com.ailearning.settingsservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI settingsServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EduGen-AI Student Settings Service API")
                        .description("Microservice for managing student themes, avatars, and notification preferences (Section 5.10)")
                        .version("1.0.0"));
    }
}
