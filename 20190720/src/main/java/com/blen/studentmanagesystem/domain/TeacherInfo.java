package com.blen.studentmanagesystem.domain;

import com.blen.studentmanagesystem.controller.req.TeacherInfoCreateParam;
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

public class TeacherInfo {

  private Long id;

  private Long code;

  private String name;

  private String sex;

  private Integer age;

  private String classname;

  //TODO: private String password;

  public static TeacherInfo buildFromCreatParam(TeacherInfoCreateParam creatParam) {
    return TeacherInfo.builder()
        .code(creatParam.getCode())
        .name(creatParam.getName())
        .sex(creatParam.getSex())
        .age(creatParam.getAge())
        .classname(creatParam.getClassname())
        .build();
  }
}