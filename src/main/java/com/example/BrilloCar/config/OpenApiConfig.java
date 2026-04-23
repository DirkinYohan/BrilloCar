package com.example.BrilloCar.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BrilloCar API")
                        .version("1.0")
                        .description("Sistema de gestión para centro de lavado de vehículos")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo BrilloCar")
                                .email("dirkinpatron@gmail.com")));
    }
}
