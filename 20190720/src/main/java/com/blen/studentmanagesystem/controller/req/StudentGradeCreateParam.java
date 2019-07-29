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
@ApiModel("成绩信息")
@JsonIgnoreProperties(ignoreUnknown = true)


public class StudentGradeCreateParam {

  @NotNull
  @Min(value = 0, message = "INVALID_CODE")
  @Max(value = Regex.CODE_MAX, message = "INVALID_")
  @ApiModelProperty("学生编号")
  private Long code;

  @NotNull
  @Pattern(regexp = Regex.NAME, message = "INVALID_NAME")
  @ApiModelProperty("学生姓名")
  @NotNull
  private String name;

  @NotNull
  @Min(value = 2000, message = "INVALID_YEAR")
  @Max(value = 3000, message = "INVALID_YEAR")
  @ApiModelProperty("学年")
  private int year;

  @NotNull
  @Min(value = 0, message = "INVALID_MATH_GRADE")
  @Max(value = 150, message = "INVALID_MATH_GRADE")
  @ApiModelProperty("数学成绩")
  private double math;

  @NotNull
  @Min(value = 0, message = "INVALID_ENGLISH_GRADE")
  @Max(value = 150, message = "INVALID_ENGLISH_GRADE")
  @ApiModelProperty("英语成绩")
  private double english;

  @NotNull
  @Min(value = 0, message = "INVALID_CHINESE_GRADE")
  @Max(value = 150, message = "INVALID_CHINESE_GRADE")
  @ApiModelProperty("语文成绩")
  private double chinese;

//TODO
//  @ApiParam(value = "密码", required = true)
//  @NotNull
//  private String password;
}
