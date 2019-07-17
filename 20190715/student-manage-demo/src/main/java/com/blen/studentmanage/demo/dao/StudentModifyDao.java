package com.blen.studentmanage.demo.dao;

import com.blen.studentmanage.demo.domain.Student;

public interface StudentModifyDao {

  void addStudent(Student student);

  void deleteStudent(long id);

  void updateStudent(Student student);

  Student getStudent(long id);

}
