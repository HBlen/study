package com.blen.injection.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTester {

  @Bean(name = "testBean")
  public String test(){
    String str = "测试@Bean注解";
    return str;

  }
}
