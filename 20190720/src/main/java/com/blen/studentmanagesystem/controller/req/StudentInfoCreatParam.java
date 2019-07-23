package com.blen.studentmanagesystem.controller.req;


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
@ApiModel("学生信息")
@JsonIgnoreProperties(ignoreUnknown = true)

public class StudentInfoCreatParam {

  @ApiParam(value = "学号", required = true)
  @NotNull
  private Long code;

  @ApiParam(value = "姓名", required = true)
  @NotNull
  private String name;

  @ApiParam(value = "性别", required = true)
  @NotNull
  private String sex;

  @ApiParam(value = "年龄", required = true)
  @NotNull
  private Integer age;

  @ApiParam(value = "班级", required = true)
  @NotNull
  private String classname;

}
