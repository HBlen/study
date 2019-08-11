package com.blen.injection.chu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testMain {
  public static void main(String[] args){

    ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);//初始化IOC容器
    Student student = (Student) context.getBean("student1",Student.class);
    int id =student.getId();
  }

}
