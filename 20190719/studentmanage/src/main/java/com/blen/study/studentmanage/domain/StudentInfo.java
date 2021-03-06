package com.blen.study.studentmanage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StudentInfo {
  private Long s_id;
  private Long s_code;
  private String s_name;
  private String s_sex;
  private Integer s_age;
  private String classname;
}
//  public StudentInfo (long s_code,String s_name,String s_sex, int s_age,String classname){
//    this.s_code = s_code;
//    this.s_name = s_name;
//    this.s_sex = s_sex;
//    this.s_age = s_age;
//    this.classname = classname;
//  }
//  public long getS_code(){
//    return s_code;
//  }
//  public String toString(){
//    return "StudentInfo[ code: " + s_code + ",name: "
//        + s_name
//        + ", sex: "
//        + s_sex
//        + ", age: "
//        + s_age
//        + ", classname: "
//        + classname
//        + "]";
//  }
//}