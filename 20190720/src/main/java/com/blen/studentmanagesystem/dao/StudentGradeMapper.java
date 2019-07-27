package com.blen.studentmanagesystem.dao;

import com.blen.studentmanagesystem.controller.req.StudentGradeRemoveParam;
import com.blen.studentmanagesystem.domain.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentGradeMapper {

  Long addStudentGrade(StudentGrade studentGrade);

  Integer deleteStudentGrade( StudentGradeRemoveParam removeParam);

  Integer updateStudentGrade(StudentGrade studentGrade);

  StudentGrade getStudentGrade(
      @Param("code") Long code,
      @Param("year") Integer year);
}
