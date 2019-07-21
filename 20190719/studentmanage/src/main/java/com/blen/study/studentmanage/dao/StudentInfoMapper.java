package com.blen.study.studentmanage.dao;

import com.blen.study.studentmanage.domain.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentInfoMapper {
  Long addStudentInfo(StudentInfo studentInfo);

  String deleteStudentInfo(@Param("s_code") Long s_code);

  Integer updateStudentInfo(StudentInfo studentInfo);

  StudentInfo getStudentInfo(@Param("s_code") Long s_code);

 // List<StudentInfo> listStudentInfo(Long start, Long count);
}
