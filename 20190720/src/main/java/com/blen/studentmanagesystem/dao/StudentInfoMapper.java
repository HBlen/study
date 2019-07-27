package com.blen.studentmanagesystem.dao;

import com.blen.studentmanagesystem.controller.req.StudentInfoRemoveParam;
import com.blen.studentmanagesystem.domain.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentInfoMapper {

  Long addStudentInfo(StudentInfo studentInfo);

  Integer deleteStudentInfo(StudentInfoRemoveParam removeParam);

  Integer updateStudentInfo(StudentInfo studentInfo);

  StudentInfo getStudentInfo(
      @Param("code") Long code,
      @Param("name") String name);

}
