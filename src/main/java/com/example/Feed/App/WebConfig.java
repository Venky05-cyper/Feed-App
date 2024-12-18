package com.example.Feed.App;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // Allow all endpoints
				.allowedOrigins("http://localhost:3000") // Allow requests from React app
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
				.allowedHeaders("*") // Allow all headers
				.allowCredentials(true); // Allow credentials
	}
}
