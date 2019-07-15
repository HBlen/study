package com.blen.studentmanage.demo;

import java.util.ArrayList;

import com.blen.studentmanage.demo.dao.StudentModify;
import com.blen.studentmanage.demo.domain.Student;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  //  ArrayList<Student> studentList=new ArrayList<>();

  //  Student student=new Student("zhangsan","female",19,"13020001114","science",90);
    StudentModify studentModify = new StudentModify();
    studentModify.addStudent("zhangsan","female",19,"13020001114","science",90);
  }

}
