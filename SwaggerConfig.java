package com.mydev.mystu.jee4exam.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
@AutoConfigureAfter
@Slf4j
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enable;

    @Value("${swagger.host}")
    private String host;

    @Bean
    public Docket commonRestApi() {
//        List<Parameter> headerParamList = getHeaderParameterList();
//        List<ResponseMessage> responseMessageList = getResponseMessageList();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("接口api")
                .apiInfo(getCommonApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mydev.mystu.jee4exam.controller"))
                .build()
//                .globalOperationParameters(headerParamList)
//                .globalResponseMessage(RequestMethod.GET, responseMessageList)
//                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .host(host)
                .enable(enable);
    }

//    private List<Parameter> getHeaderParameterList() {
//        ParameterBuilder headerParam = new ParameterBuilder();
//        List<Parameter> headerParamList = new ArrayList<>();
//        headerParam.name("test_user_id").description("用于测试时传送给后端的用户id")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build(); //header中的ticket参数非必填，传空也可以
//        headerParamList.add(headerParam.build());
//
//        headerParam = new ParameterBuilder();
//        headerParam.name("client-type").description("客户端类型: B \\ C")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build(); //header中的ticket参数非必填，传空也可以
//        headerParamList.add(headerParam.build());
//        return headerParamList;
//    }
//
//    private List<ResponseMessage> getResponseMessageList() {
//        List<ResponseMessage> responseMessageList = new ArrayList<>();
//        responseMessageList.add(new ResponseMessageBuilder().code(1001).message("需要登录").responseModel(new ModelRef("ApiError")).build());
//        responseMessageList.add(new ResponseMessageBuilder().code(1002).message("无权访问").responseModel(new ModelRef("ApiError")).build());
//        return responseMessageList;
//    }

    private ApiInfo getCommonApiInfo() {
        return new ApiInfoBuilder()
                .title("接口列表")
                .build();
    }

}
