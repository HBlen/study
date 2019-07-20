package com.blen.study.studentmanage.service;

import com.blen.study.studentmanage.controller.req.StudentInfoCreatParam;
import com.blen.study.studentmanage.dao.StudentInfoMapper;
import com.blen.study.studentmanage.domain.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoService {

  @Autowired
  private StudentInfoMapper studentInfoMapper;

  /**
   * 添加学生
   * @param StudentInfo  学生信息
   */

  public long addStudentInfo(StudentInfoCreatParam studentInfoCreatParam) {
    StudentInfo studentInfo = new StudentInfo(studentInfoCreatParam.getS_code(),
        studentInfoCreatParam.getS_name(),
        studentInfoCreatParam.getS_sex(),
        studentInfoCreatParam.getS_age(),
        studentInfoCreatParam.getClassname());
    studentInfoMapper.addStudentInfo(studentInfo);
    return studentInfo.getS_code();
  }

  /**
   * 根据id删除学生
   *
   * @param s_code 学生学号
   */
  public String deleteStudentInfo(long s_code) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(s_code);
    if(studentInfoResp == null){
      return "无该学号学生";
    }
    return studentInfoMapper.deleteStudentInfo(s_code);
  }

  /**
   * 更新学生信息
   *
   * @param StudentInfoCreatParam 学生信息
   */
  public int updateStudentInfo(StudentInfoCreatParam studentInfoCreatParam) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(studentInfoCreatParam.getS_code());
    if(studentInfoResp == null){
      return 404;
    }

    StudentInfo studentInfoReq = new  StudentInfo(studentInfoCreatParam.getS_code(),
        studentInfoCreatParam.getS_name(),
        studentInfoCreatParam.getS_sex(),
        studentInfoCreatParam.getS_age(),
        studentInfoCreatParam.getClassname());
    return studentInfoMapper.updateStudentInfo(studentInfoReq);

  }

  /**
   * 根据id查找学生信息
   *
   * @param id 学生学号
   * @return StudentInfo 学生信息
   */
  public StudentInfo  getStudentInfo(long s_code) {

    StudentInfo studentInfo = studentInfoMapper.getStudentInfo(s_code);
    if (studentInfo == null) {
      return null;
    }
    return studentInfo;

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
