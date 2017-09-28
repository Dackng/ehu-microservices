package com.unmsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LaboratoryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryTestApplication.class, args);
	}
	
	/**
	 * Remove when the project has finished because this method help to resolve the CORS problem
	 * @return
	 */
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                		.allowedOrigins("http://localhost:3000", "https://ehu-unmsm.firebaseapp.com")
                		.allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
     }
}
