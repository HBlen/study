package com.blen.studentmanage.demo.dao;

import java.util.ArrayList;
import java.util.Scanner;

import com.blen.studentmanage.demo.domain.Student;

public class StudentModify {
  private ArrayList <Student>studentList = new ArrayList <> ();
// Scanner scanner=new Scanner(System.in);

  public void addStudent(String name,String sex, int age,String id,String major,double grade){  //String name,String sex, int age,String id,String major,double grade
    Student student = new Student(name, sex, age, id, major, grade);
    studentList.add(student);
  }

  public void deleteStudent(String id){
    for(int i = 0;i<studentList.size();i++){
      if(id.equals(studentList.get(i).getId())) {
        studentList.remove(i);
        break;
      }
    }
  }

  public void updateStudent(Student student){
    for(int i = 0;i<studentList.size();i++){
      if(student.getId().equals(studentList.get(i).getId())) {
        studentList.get(i).setAge(student.getAge());
        studentList.get(i).setGrade(student.getGrade());
        studentList.get(i).setMajor(student.getMajor());
        studentList.get(i).setName(student.getName());
        studentList.get(i).setSex(student.getSex());
        break;
      }
    }
  }



  public Student getStudent(String id ){

    for(int i = 0;i<studentList.size();i++){
      if(id.equals(studentList.get(i).getId())) {
            return studentList.get(i);
        }
      }
    return null;
  }

}
