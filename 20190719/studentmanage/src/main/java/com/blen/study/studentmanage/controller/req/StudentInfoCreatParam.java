package com.blen.study.studentmanage.controller.req;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("业务能力")
@JsonIgnoreProperties(ignoreUnknown = true)

public class StudentInfoCreatParam {

  @ApiParam(value = "学号", required = true)
  @NotNull
  private Long s_code;

  @ApiParam(value = "姓名", required = true)
  @NotNull
  private String s_name;

  @ApiParam(value = "性别", required = true)
  @NotNull
  private String s_sex;

  @ApiParam(value = "年龄", required = true)
  @NotNull
  private Integer s_age;

  @ApiParam(value = "班级", required = true)
  @NotNull
  private String classname;


//
//  public long getS_code(){
//    return s_code;
//  }
//  public String getS_name(){
//    return s_name;
//  }
//  public String getS_sex(){
//    return s_sex;
//  }
//  public int getS_age(){
//    return s_age;
//  }
//  public String getClassname(){
//    return classname;
//  }
}
