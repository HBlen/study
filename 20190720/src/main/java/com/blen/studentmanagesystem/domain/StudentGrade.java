package com.blen.studentmanagesystem.domain;

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
}