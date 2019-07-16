package com.blen.studentmanage.demo.service;

import java.util.ArrayList;

import com.blen.studentmanage.demo.dao.StudentModifyDao;
import com.blen.studentmanage.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentModifyService  {

  @Autowired
  private StudentModifyDao studentModifyDao;

  private ArrayList <Student>studentList = new ArrayList<>();

  /**
   * 添加学生
   *
   *
   * @param name
   * @param sex
   * @param age
   * @param id
   * @param major
   * @param grade
   */
  public void addStudent(Student student){
   // Student student = new Student(name, sex, age, id, major, grade);
    studentList.add(student);
  }

  /**
   * 根据id删除学生
   *
   * @param id
   */
  public void deleteStudent(long id){
    for(int i = 0;i<studentList.size();i++){
      if(id == studentList.get(i).getId()) {
        studentList.remove(i);
        break;
      }
    }
  }

  /**
   * 更新学生信息
   *
   * @param student
   */
  public void updateStudent(Student student){
    for(int i = 0;i<studentList.size();i++){
      if(student.getId()==studentList.get(i).getId()) {
        studentList.get(i).setAge(student.getAge());
        studentList.get(i).setGrade(student.getGrade());
        studentList.get(i).setMajor(student.getMajor());
        studentList.get(i).setName(student.getName());
        studentList.get(i).setSex(student.getSex());
        break;
      }
    }
  }


  /**
   * 根据id查找学生信息
   *
   * @param id
   * @return
   */
  public Student getStudent(long id ){

    for(int i = 0;i<studentList.size();i++){
      if(id==studentList.get(i).getId()) {
        return studentList.get(i);
      }
    }
    return null;
  }

}