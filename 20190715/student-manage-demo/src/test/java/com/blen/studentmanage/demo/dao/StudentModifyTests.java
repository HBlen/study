package com.blen.studentmanage.demo.dao;

import com.blen.studentmanage.demo.DemoApplicationTests;
import com.blen.studentmanage.demo.domain.Student;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StudentModifyTests extends DemoApplicationTests {
  StudentModify studentModify = new StudentModify();

  @Test
  public void add_student_data(){
    studentModify.addStudent("zhangsan","female",19,"13020001114","science",90);
    String name = "zhangsan";
    Student student = studentModify.getStudent("13020001114");
    assertTrue(name == student.getName());
  }

}
