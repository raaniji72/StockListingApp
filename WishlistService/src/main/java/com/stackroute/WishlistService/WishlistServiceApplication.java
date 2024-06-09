package com.stackroute.WishlistService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.WishlistService.Filter.FavouriteFilter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(info = @Info(title = "wishlist API", version = "1.0", description = "UserDetails API"))
//@SecurityScheme( name = "Bearer Authentication",
//type = SecuritySchemeType.HTTP,
//bearerFormat = "JWT",
//scheme = "bearer")
@SpringBootApplication 
public class WishlistServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishlistServiceApplication.class, args);
	}
	


@Bean
public FilterRegistrationBean getfilter()
{
	FilterRegistrationBean fbean=new FilterRegistrationBean();
	fbean.setFilter(new FavouriteFilter());
	fbean.addUrlPatterns("/wishlist/*");
	return fbean;
}
}