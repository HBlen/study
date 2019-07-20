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

public class TeacherInfo {
  private Long t_id;
  private Long t_code;
  private String t_name;
  private String t_sex;
  private Integer t_age;
  private String classname;
}