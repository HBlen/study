package com.blen.study.studentmanage.service;

import com.blen.study.studentmanage.dao.TeacherInfoMapper;
import com.blen.study.studentmanage.domain.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoService {
  @Autowired
  private TeacherInfoMapper teacherInfoMapper;

  public TeacherInfo  getTeacherInfo(Long t_code) {

    return teacherInfoMapper.getTeacherInfo(t_code);
  }

}
