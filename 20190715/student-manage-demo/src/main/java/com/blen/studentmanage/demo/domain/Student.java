package com.blen.studentmanage.demo.domain;

public class Student{
  private String name;
  private String sex;
  private int age;
  private long id;
  private String major;
  private double grade;

  public Student (String name,String sex, int age,long id,String major,double grade){
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.id = id;
    this.major = major;
    this.grade = grade;
  }

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public  String getSex(){
    return  sex;
  }
  public  void setSex(String sex){
    this.sex = sex;
  }
  public long getId(){
    return id;
  }
  /* public void setId(String id){
     this.id = id;
   }*/
  public int getAge(){
    return age;
  }
  public void setAge(int age){
    this.age = age;
  }
  public String getMajor(){
    return major;
  }

  public double getGrade(){
    return grade;
  }

  public void setMajor(String major){
    this.major = major;
  }

  public void setGrade(double grade){
    this.grade = grade;
  }

  public String toString(){
    return "Student[name: " + name + ", sex: " + sex + ", age: " + age
        + ", Id: " + id + ", major: " + major + ", grade: " + grade + "]";
  }
 /* public Student createStudent(String name,String sex, int age,long id,String major,double grade){
  return new Student(name, sex, age, id, major, grade);
  }
  public boolean delete(){

  }
  public boolean update(){

  }
  public boolean getById(){

  }
  */
}
