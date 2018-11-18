package com.springboot.DbsHackthon;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories
@SpringBootApplication
@EnableSwagger2
public class StudentResultsApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentResultsApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("springboot").apiInfo(apiInfo()).select()
				.paths(regex("/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot REST API with Swagger")
				.description("SpringBoot REST API with Swagger").termsOfServiceUrl("")
				.license("Apache License Version 2.0").licenseUrl("StudentProject").version("2.0").build();
	}
}
