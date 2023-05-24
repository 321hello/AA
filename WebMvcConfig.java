package com.mydev.mystu.jee4exam.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/classes/templates/");//注意：运行时页面自动编译到这个目录下，spring boot用Thymeleaf作为模板，所以不需要这样配置
//		viewResolver.setSuffix(".jsp");
//		viewResolver.setViewClass(JstlView.class);
//		return viewResolver;
//	}

//	 @Override
//	   public void addViewControllers(ViewControllerRegistry registry) {
//	       registry.addViewController("/ws").setViewName("/ws");
//	       registry.addViewController("/login").setViewName("/login");
//	       registry.addViewController("/chat").setViewName("/chat");
//	   }

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		/**
		 * 序列换成json时,将所有的long变成string
		 * 因为js中得数字类型不能包含所有的java long值
		 */
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		converters.add(jackson2HttpMessageConverter);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
				.addVersionStrategy(new ContentVersionStrategy(), "/**");
		registry.addResourceHandler("/**/*.*")
				.addResourceLocations("classpath:/static/","/webjars/","/v2/","/swagger-resources/**","/swagger-resources","/swagger-ui.html")
				.setCachePeriod(60 * 60 * 24 * 365) /* one year */
				.resourceChain(true)
				.addResolver(versionResourceResolver);
	}

	@Bean
	public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
		return new ResourceUrlEncodingFilter();
	}


}
