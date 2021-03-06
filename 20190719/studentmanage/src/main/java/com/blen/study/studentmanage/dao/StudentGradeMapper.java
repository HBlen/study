package com.blen.study.studentmanage.dao;

import com.blen.study.studentmanage.domain.StudentGrade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentGradeMapper {

  Long addStudentGrade(StudentGrade studentGrade);

  String deleteStudentGrade( Long s_code, Integer g_year);

  Integer updateStudentGrade(StudentGrade studentGrade);

  StudentGrade getStudentGrade(Long s_code, Integer g_year);
}
