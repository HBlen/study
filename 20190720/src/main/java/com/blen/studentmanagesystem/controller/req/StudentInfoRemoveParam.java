package com.blen.studentmanagesystem.controller.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

public class StudentInfoRemoveParam {

  @NotNull
  @Min(value = 0, message = "INVALID_CODE")
  @Max(value = Regex.CODE_MAX, message = "INVALID_CODE")
  @ApiModelProperty("code")
  private Long code;

  @NotNull
  @Pattern(regexp = Regex.NAME, message = "INVALID_NAME")
  @ApiModelProperty("name")
  private String name;
}
