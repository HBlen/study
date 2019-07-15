package com.blen.studentmanage.demo.domain;

public class Person {
  private String name;
  private String sex;
  private int age;
  private  String id;

  public Person(String name, String sex, int age, String id){
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.id = id;
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
  public String getId(){
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
}
