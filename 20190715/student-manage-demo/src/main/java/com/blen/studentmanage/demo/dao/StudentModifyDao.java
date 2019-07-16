package com.blen.studentmanage.demo.dao;

import com.blen.studentmanage.demo.domain.Student;

public interface StudentModifyDao {

  void addStudent(String name,
      String sex,
      int age,
      long id,
      String major,
      double grade);

  void deleteStudent(long id);

  void updateStudent(Student student);

  Student getStudent(long id);

}
