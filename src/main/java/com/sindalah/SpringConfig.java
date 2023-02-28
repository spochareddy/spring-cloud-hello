package com.sindalah;

import com.sindalah.util.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sindalah")).paths(PathSelectors.regex("/.*")).build();
	}

	@Bean
	FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/api/v1/contacts");
		return filter;
	}
}
