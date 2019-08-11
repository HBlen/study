package com.blen.injection.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class testMain {
  public static void main(String[] args){
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    StudentService studentService = context.getBean("studentService", StudentServiceImp.class);
    studentService.printStudentInfo();
  }

}
