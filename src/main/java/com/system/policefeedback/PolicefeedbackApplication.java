package com.system.policefeedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PolicefeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicefeedbackApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry reg) {
                reg.addMapping("/**")
                   .allowedOrigins(
                       "http://127.0.0.1:5501/",
                       "https://127.0.0.1:5501/",
                       "localhost:8085"
                       
                       
                       
                       
                       
                       
                   )
                   .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                   .allowedHeaders("*")
                   .allowCredentials(true);
            }
        };
	}
  
}
