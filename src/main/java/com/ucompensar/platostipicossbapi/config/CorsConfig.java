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
                        .allowedOriginPatterns("*") // Allowed compatibility all origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //Allowed all methods
                        .allowedHeaders("*") // Allowed all headers (Content-Type, Authorization, etc.)
//                        .exposedHeaders("Authorization")  pendent for include jwt
                        .allowCredentials(true);
            }
        };
    }
}
