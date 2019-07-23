package com.blen.studentmanagesystem.dao;

import com.blen.studentmanagesystem.domain.StudentGrade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentGradeMapper {

  Long addStudentGrade(StudentGrade studentGrade);

  Integer deleteStudentGrade( Long code, Integer year);

  Integer updateStudentGrade(StudentGrade studentGrade);

  StudentGrade getStudentGrade(Long code, Integer year);
}
