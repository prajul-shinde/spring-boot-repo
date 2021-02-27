package com.gfg.lecture1;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//add annnotation
//url for swagger ui = http://localhost:8080/swagger-ui.html
@EnableSwagger2
@SpringBootApplication

public class Lecture1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture1Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// .paths and apis for removing default mvc apis

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.gfg")).build().apiInfo(apiDetails());
		// .apiinfo for adding metadata
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Credit Systems India", "Prajul api", "1.0", "free to use",
				new springfox.documentation.service.Contact("prajul shinde", "https://github.com/prajul-shinde",
						"prajulshinde@gmail.com"),
				"@CSI All right reserved", "CSI Pune", Collections.emptyList());
	}

}
