package com.blen.studentmanagesystem.dao;

import com.blen.studentmanagesystem.domain.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherInfoMapper {

 TeacherInfo getTeacherInfo(Long code,String name);

 Long addTeacherInfo(TeacherInfo teacherInfo);

 Integer deleteTeacherInfo(Long code, String name);

 Integer updateTeacherInfo(TeacherInfo teacherInfo);

 //TODO :
 // TeacherInfo loginTeacher(Long code,String password);

}
