package com.blen.study.studentmanage.dao;

import com.blen.study.studentmanage.domain.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentInfoMapper {
  Long addStudentInfo(StudentInfo studentInfo);

  String deleteStudentInfo(Long s_code);

  Integer updateStudentInfo(StudentInfo studentInfo);

  StudentInfo getStudentInfo(Long s_code);

 // List<StudentInfo> listStudentInfo(Long start, Long count);
}
