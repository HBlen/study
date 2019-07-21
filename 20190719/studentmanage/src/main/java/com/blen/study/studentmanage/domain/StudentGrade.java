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

public class StudentGrade {
  private Long g_id;
  private Long s_code;
  private String s_name;
  private Integer g_year;
  private Double g_math;
  private Double g_english;
  private Double g_chinese;
}