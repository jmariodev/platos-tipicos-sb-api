package com.ucompensar.platostipicossbapi.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    // Configures CORS for the application
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins()
                        .allowedOriginPatterns("*") // Allows request from any origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allows specified HTTP methods
                        .allowedHeaders() // Allows all headers
                        .allowCredentials(true); // Allows credentials (e.g., cookies)
            }
        };
    }
}
