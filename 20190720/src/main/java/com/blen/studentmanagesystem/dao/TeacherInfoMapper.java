package com.blen.studentmanagesystem.dao;

import com.blen.studentmanagesystem.controller.req.TeacherInfoRemoveParam;
import com.blen.studentmanagesystem.domain.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherInfoMapper {

 TeacherInfo getTeacherInfo(
     @Param("code") Long code,
     @Param("name") String name);

 Long addTeacherInfo(TeacherInfo param);

 Integer deleteTeacherInfo(TeacherInfoRemoveParam removeParam);

 Integer updateTeacherInfo(TeacherInfo teacherInfo);

 //TODO :
 // TeacherInfo loginTeacher(Long code,String password);

}
