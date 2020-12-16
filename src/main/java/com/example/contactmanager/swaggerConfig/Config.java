package com.example.contactmanager.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class Config {

    @Bean
    public Docket swaggerConfiguration() {
        //Return a docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //package restriction
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                //api package
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Contact Manager",
                "Sample API for learning Spring Boot, Swagger, REST APIs",
                "Version: 001",
                "Free To Test",
                new springfox.documentation.service.Contact("Valliant Lupori", "http://localhost:8080/contacts", "v@l.com"),
                "API License",
                "http://springfox.github.io/springfox/javadoc/2.6.0/index.html?springfox/documentation/service/ApiInfo.html",
                Collections.emptyList());
    }

}
