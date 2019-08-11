package com.blen.injection.service;

import com.blen.injection.chu.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentService")
public class StudentServiceImp implements StudentService{

  @Autowired
  private Student student = null;

  public void printStudentInfo(){
    System.out.println("学生的 id 为 ：" + student.getId());
    System.out.println("学生的name 为："+ student.getName());
  }

}
