package com.blen.student_manage_system;

import org.mybatis.spring.annotation.MapperScan;
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

@Configuration
@EnableSwagger2
@MapperScan("com.blen.student_manage_system.dao;")
@SpringBootApplication
public class StudentManageSystemApplication {

  @Value("${swagger2.enable: true}")
  private boolean swaggerSwitch;
  public static void main(String[] args) {
    SpringApplication.run(StudentManageSystemApplication.class, args);
}
    @Bean
    public Docket createSwaggerDocket() {

      //  Swagger API 配置

      return new Docket(DocumentationType.SWAGGER_2)
          .enable(swaggerSwitch)
          .select()
          .apis(RequestHandlerSelectors.any())
          .apis(RequestHandlerSelectors.basePackage("com.blen.student_manage_system.controller"))
          .paths(PathSelectors.any())
          .build();
    }

  }

