package com.blen.studentmanagesystem.dao;

import com.blen.studentmanagesystem.domain.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentInfoMapper {
  Long addStudentInfo(StudentInfo studentInfo);

  Integer deleteStudentInfo(Long code,String name);

  Integer updateStudentInfo(StudentInfo studentInfo);

  StudentInfo getStudentInfo(Long code, String name);

}
