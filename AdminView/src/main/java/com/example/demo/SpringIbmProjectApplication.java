package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableMongoRepositories(basePackages = {"com.example.demo.mongorepository"})
@EnableJpaRepositories (basePackages = {"com.example.demo.repository"})
public class SpringIbmProjectApplication extends WebMvcConfigurerAdapter 
{

	public static void main(String[] args) {
		SpringApplication.run(SpringIbmProjectApplication.class, args);
		
		
	}

}
