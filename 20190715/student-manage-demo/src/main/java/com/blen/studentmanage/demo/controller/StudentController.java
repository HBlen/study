package com.blen.studentmanage.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  @RequestMapping(value = "/h",method = RequestMethod.GET)
  public String sayHello(){
    return "hello world";
  }
}

