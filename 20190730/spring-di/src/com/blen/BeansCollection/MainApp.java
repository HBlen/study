package com.blen.BeansCollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("BeansCollection.xml");
    JavaCollection jc=(JavaCollection)context.getBean("javaCollection");
    jc.getAddressList();
    jc.getAddressSet();
    jc.getAddressMap();
    jc.getAddressProp();
  }
}
