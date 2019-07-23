package com.blen.studentmanagesystem.service;

import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.StudentInfoCreatParam;
import com.blen.studentmanagesystem.dao.StudentInfoMapper;
import com.blen.studentmanagesystem.domain.StudentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentInfoService {

  @Autowired
  private StudentInfoMapper studentInfoMapper;

  /**
   * 校验数据是否存在
   * @param studentInfo
   */
  private void checkStudentInfo(StudentInfo studentInfo) {
    if (studentInfo == null) {
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }
  }

  /**
   * 添加学生
   * @param   学生信息
   */

  public long addStudentInfo(StudentInfoCreatParam param) {
    StudentInfo studentInfo = StudentInfo.builder()
        .code(param.getCode())
        .name(param.getName())
       .sex(param.getSex())
        .age(param.getAge())
        .classname(param.getClassname())
        .build();

    try {
      studentInfoMapper.addStudentInfo(studentInfo);
    } catch (DuplicateKeyException e) {
      return studentInfoMapper.getStudentInfo(param.getCode(),param.getName()).getId();
    } catch (Exception e) {
      log.error("addStudentInfo exception:{} ", studentInfo.toString(), e);
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }

    return studentInfo.getId();
  }

  /**
   * 根据id删除学生
   *
   * @param code 学生学号
   */
  public int  deleteStudentInfo(Long code,String name) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(code,name);
    checkStudentInfo(studentInfoResp);
    return studentInfoMapper.deleteStudentInfo(code,name);
    }

  /**
   * 更新学生信息
   *
   * @param studentInfoCreatParam 学生信息
   */
  public int updateStudentInfo(StudentInfoCreatParam param) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(param.getCode(),param.getName());
    checkStudentInfo(studentInfoResp);
    StudentInfo studentInfoReq = StudentInfo.builder()
        .code(param.getCode())
        .name(param.getName())
        .sex(param.getSex())
        .age(param.getAge())
        .classname(param.getClassname())
        .build();
    return studentInfoMapper.updateStudentInfo(studentInfoReq);

  }

  /**
   * 根据id查找学生信息
   *
   * @param code 学生学号
   * @param name 姓名
   * @return StudentInfo 学生信息
   */
  public StudentInfo  getStudentInfo(Long code, String name) {
   StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(code, name);
    checkStudentInfo(studentInfoResp);
    return studentInfoResp;
  }

}
