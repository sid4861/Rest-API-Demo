package com.api.demo.employee.employee_api;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Contact DEFAULT_CONTACT = new Contact("Siddharth Lodha", "", "siddharth.lodha1@t-mobile.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Employee API Demo","RESTful Employee web services created using spring boot and MongoDB", "1.0", "", DEFAULT_CONTACT, "Apache Open Source", "");

	public SwaggerConfig() {
		
	}
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}
}
