package com.react.swag.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfigClass {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.react.swag.controller"))
				.paths(PathSelectors.any()).build().apiInfo(appinfo());
	}

	private ApiInfo appinfo() {
		return new ApiInfo("CompanyDetails"
				, "This app is Used to fetch all Comapny Details"
						+ "and search by id insert and Delete", 
						"Sprinf version is 2.7.12 7 java version is 8"
						, "http://localhost:8080/api/insert", "9515656429",
						"localhost mysql", "jhfhjfhjhj");
	}
	
	
}
