package com.blen.studentmanagesystem.controller.req;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.blen.studentmanagesystem.common.constans.Regex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

public class StudentInfoCreateParam {

  @NotNull
  @Min(value = 0, message = "INVALID_CODE")
  @Max(value = 100000000, message = "INVALID_CODE")
  @ApiModelProperty("学生学号")
  private Long code;

  @NotNull
  @Pattern(regexp = Regex.NAME, message = "INVALID_NAME")
  @ApiModelProperty("学生姓名")
  @NotNull
  private String name;

  @NotNull
  @Pattern(regexp = Regex.SEX, message = "INVALID_SEX")
  @ApiModelProperty("性别")
  private String sex;

  @NotNull
  @Min(value = 0, message = "INVALID_AGE")
  @Max(value = 100, message= "INVALID_AGE")
  @ApiModelProperty("年龄")
  private Integer age;

  @NotNull
  @Pattern(regexp = Regex.CALSSNAME, message ="INVALID_CLASSNAME")
  @ApiModelProperty("班级")
  private String classname;

}
