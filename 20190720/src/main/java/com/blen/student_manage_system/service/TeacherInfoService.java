package com.blen.student_manage_system.service;

import com.blen.student_manage_system.dao.TeacherInfoMapper;
import com.blen.student_manage_system.domain.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoService {

  @Autowired
  private TeacherInfoMapper teacherInfoMapper;

  public TeacherInfo  getTeacherInfo(Long t_code,String t_name) {

    return teacherInfoMapper.getTeacherInfo(t_code,t_name);
  }

  public String  loginTeacher(Long t_code,String password) {

    TeacherInfo teacherInfo = teacherInfoMapper.loginTeacher(t_code,password);
    if(teacherInfo == null){
      return "编号或密码错误";
       }
    return "teacher[code: " + teacherInfo.getT_code()+", name: " + teacherInfo.getT_name() + ", classname: " + teacherInfo.getClassname() + "]";
  }
}
