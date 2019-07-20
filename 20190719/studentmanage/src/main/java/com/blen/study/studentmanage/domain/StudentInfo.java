package com.blen.study.studentmanage.domain;


public class StudentInfo {
  private long s_id;
  private long s_code;
  private String s_name;
  private String s_sex;
  private int s_age;
  private String classname;

  public StudentInfo (long s_code,String s_name,String s_sex, int s_age,String classname){
    this.s_code = s_code;
    this.s_name = s_name;
    this.s_sex = s_sex;
    this.s_age = s_age;
    this.classname = classname;
  }
  public long getS_code(){
    return s_code;
  }
  public String toString(){
    return "StudentInfo[ code: " + s_code + ",name: "
        + s_name
        + ", sex: "
        + s_sex
        + ", age: "
        + s_age
        + ", classname: "
        + classname
        + "]";
  }
}