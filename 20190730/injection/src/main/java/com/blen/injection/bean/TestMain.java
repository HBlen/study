package com.blen.injection.bean;

import javax.swing.border.CompoundBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
  public static void main(String[] args){
    ApplicationContext context = new AnnotationConfigApplicationContext("com.blen.injection.bean");
    System.out.println(context.getBean("testBean"));
  }


}
