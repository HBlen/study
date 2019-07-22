package com.blen.student_manage_system.service;

import com.blen.student_manage_system.controller.req.StudentInfoCreatParam;
import com.blen.student_manage_system.dao.StudentInfoMapper;
import com.blen.student_manage_system.domain.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoService {

  @Autowired
  private StudentInfoMapper studentInfoMapper;

  /**
   * 添加学生
   * @param studentInfoParam  学生信息
   */

  public long addStudentInfo(StudentInfoCreatParam studentInfoCreatParam) {
    StudentInfo studentInfo = StudentInfo.builder()
        .s_code(studentInfoCreatParam.getS_code())
        .s_name(studentInfoCreatParam.getS_name())
       .s_sex(studentInfoCreatParam.getS_sex())
        .s_age(studentInfoCreatParam.getS_age())
        .classname(studentInfoCreatParam.getClassname())
        .build();
    return studentInfoMapper.addStudentInfo(studentInfo);
   // studentInfo.getS_code();
  }

  /**
   * 根据id删除学生
   *
   * @param s_code 学生学号
   */
  public String  deleteStudentInfo(Long s_code) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(s_code);
    if(studentInfoResp == null){
      return "无该学号学生";
    }
    studentInfoMapper.deleteStudentInfo(s_code);
    return "deleted";
  }

  /**
   * 更新学生信息
   *
   * @param studentInfoCreatParam 学生信息
   */
  public int updateStudentInfo(StudentInfoCreatParam studentInfoCreatParam) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(studentInfoCreatParam.getS_code());
    if(studentInfoResp == null){
      return 404;
    }

    StudentInfo studentInfoReq = StudentInfo.builder()
        .s_name(studentInfoCreatParam.getS_name())
        .s_sex(studentInfoCreatParam.getS_sex())
        .s_age(studentInfoCreatParam.getS_age())
        .classname(studentInfoCreatParam.getClassname())
        .build();
    return studentInfoMapper.updateStudentInfo(studentInfoReq);

  }

  /**
   * 根据id查找学生信息
   *
   * @param s_code 学生学号
   * @return StudentInfo 学生信息
   */
  public StudentInfo  getStudentInfo(Long s_code) {

    return studentInfoMapper.getStudentInfo(s_code);
  }
//
//  public List<StudentInfo> listStudentInfo(long start,long count){
//    List<StudentInfo> studentInfoList = studentInfoMapper.listStudentInfo(start, count);
//    if (CollectionUtils.isEmpty(studentInfoList)) {
//      return Collections.emptyList();
//    }
//    return studentInfoList;
//  }
}
