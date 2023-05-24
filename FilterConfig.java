package com.mydev.mystu.jee4exam.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SimpleCorsFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        registration.setName("simpleCorsFilter");
        registration.setOrder(Integer.MAX_VALUE - 2);

        return registration;
    }

}
