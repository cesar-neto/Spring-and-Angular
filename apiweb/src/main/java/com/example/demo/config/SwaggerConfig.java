package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.ws.controller.ClienteController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackages="com.example.demo.ws.controller")
@Configuration
public class SwaggerConfig {

	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENSE_TEXT = "license";
	private static final String title = "Clientes REST API";
	private static final String description = "RESTful API for clientes";
	
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICENSE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();
	}
	
	@Bean
	public Docket clientesApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				//.paths(PathSelectors.regex("/api.*"))
				.build();
	}
	
	
}
