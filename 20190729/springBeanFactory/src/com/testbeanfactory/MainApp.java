package com.testbeanfactory;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
  public static void main(String[] args) {
    // XmlBeanFactory 使用
    //    XmlBeanFactory factory = new XmlBeanFactory
    //        (new ClassPathResource("Beans.xml"));
    //    HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
    //    obj.getMessage();

    ApplicationContext context =
        new FileSystemXmlApplicationContext("out/production/springBeanFactory/Beans.xml");
    HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    obj.getMessage();
  }
}
