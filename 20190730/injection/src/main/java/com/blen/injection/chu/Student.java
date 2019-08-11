package com.blen.injection.chu;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "student1")
public class Student {

  @Value("1")
  int id;
  @Value("student_name_1")
  String name;

  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
}
