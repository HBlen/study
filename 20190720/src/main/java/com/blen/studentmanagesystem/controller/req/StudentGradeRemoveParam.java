package com.blen.studentmanagesystem.controller.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.blen.studentmanagesystem.common.constans.Regex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Builder

public class StudentGradeRemoveParam {

  @NotNull
  @Min(value = 0, message = "INVALID_CODE")
  @Max(value = Regex.CODE_MAX, message = "INVALID_CODE")
  @ApiModelProperty("学号")
  private Long code;

  @NotNull
  @Min(value = 2000, message = "INVALID_YEAR")
  @Max(value = 3000, message = "INVALID_YEAR")
  @ApiModelProperty("学年")
  private int year;

}
