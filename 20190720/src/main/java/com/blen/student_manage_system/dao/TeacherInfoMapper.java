package com.blen.student_manage_system.dao;

import com.blen.student_manage_system.domain.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherInfoMapper {

 TeacherInfo getTeacherInfo(Long t_code,String t_name);
 TeacherInfo loginTeacher(Long t_code,String password);

}
