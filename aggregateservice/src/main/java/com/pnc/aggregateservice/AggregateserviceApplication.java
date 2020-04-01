package com.pnc.aggregateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableFeignClients
@EnableResourceServer
@EnableOAuth2Sso
public class AggregateserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregateserviceApplication.class, args);
	}

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
//
//	@Bean
//	public FilterRegistrationBean oauth2ClientFilterRegistration(
//			OAuth2ClientContextFilter filter) {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(filter);
//		registration.setOrder(-100);
//		return registration;
//	}
}
