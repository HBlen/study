package com.blen.study.studentmanage.dao;

import com.blen.study.studentmanage.domain.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherInfoMapper {

 TeacherInfo getTeacherInfo(Long t_code);

}
