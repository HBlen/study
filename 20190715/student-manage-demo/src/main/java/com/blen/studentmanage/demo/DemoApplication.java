package com.blen.studentmanage.demo;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicates;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class DemoApplication {
  @Value("${swagger2.enable: true}")
  private boolean swaggerSwitch;


  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
 /*
    StudentModify studentModify = new StudentModify();
    studentModify.addStudent("zhangsan","female",19,"13020001114","science",90);
    */

  }
  @Bean
  public Docket createSwaggerDocket() {

    //  Swagger API 配置

    return new Docket(DocumentationType.SWAGGER_2)
        .enable(swaggerSwitch)
        .select()
        .apis(RequestHandlerSelectors.any())
        .apis(RequestHandlerSelectors.basePackage("com.blen.studentmanage.demo.controller"))
        .paths(PathSelectors.any())
        .build();

  }
/*
  private Predicate<String> acceptPath(String... patterns) {
    return Predicates.or(Arrays.stream(patterns).map((s) -> {
      return PathSelectors.ant(s);
    }).collect(Collectors.toList()));
  }
  */
}
