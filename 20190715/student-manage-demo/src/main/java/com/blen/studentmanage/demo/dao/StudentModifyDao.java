package com.blen.studentmanage.demo.dao;

import com.blen.studentmanage.demo.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentModifyDao {

  void addStudent(Student student);

  void deleteStudent(long id);

  void updateStudent(Student student);

  Student getStudent(long id);

 // List<Student> listStudent(int start, int count);
}
