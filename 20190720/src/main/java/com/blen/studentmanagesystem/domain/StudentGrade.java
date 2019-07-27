package com.blen.studentmanagesystem.domain;

import com.blen.studentmanagesystem.controller.req.StudentGradeCreateParam;
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

public class StudentGrade {

  private Long id;

  private Long code;

  private String name;

  private Integer year;

  private Double math;

  private Double english;

  private Double chinese;

  public static StudentGrade buildFromCreatParam(StudentGradeCreateParam createParam) {
    return StudentGrade.builder()
        .code(createParam.getCode())
        .name(createParam.getName())
        .year(createParam.getYear())
        .math(createParam.getMath())
        .english(createParam.getEnglish())
        .chinese(createParam.getChinese())
        .build();
  }
}