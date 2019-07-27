package com.blen.studentmanagesystem.service;

import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.StudentInfoCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentInfoRemoveParam;
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
   * @param saveParam 学生信息
   */

  public long addStudentInfo(StudentInfoCreateParam saveParam) {
    StudentInfo studentInfo = StudentInfo.buildFromCreatParam(saveParam);

    try {
      return studentInfoMapper.addStudentInfo(studentInfo);
    } catch (DuplicateKeyException e) {
      return studentInfoMapper.getStudentInfo(saveParam.getCode(),saveParam.getName()).getId();
    } catch (Exception e) {
      log.error("addStudentInfo exception:{} ", studentInfo.toString(), e);
      throw new ApiException(StudentManageErrorEnum.SYSTEM_INTERNAL_ERROR);
    }
  }

  /**
   * 根据id删除学生
   *
   * @param removeParam 学生信息
   */
  public int  deleteStudentInfo(StudentInfoRemoveParam removeParam ) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(removeParam.getCode(),removeParam.getName());
    checkStudentInfo(studentInfoResp);

    return studentInfoMapper.deleteStudentInfo(removeParam);
    }

  /**
   * 更新学生信息
   *
   * @param saveParam 学生信息
   */
  public int updateStudentInfo(StudentInfoCreateParam saveParam) {
    StudentInfo studentInfoResp = studentInfoMapper.getStudentInfo(saveParam.getCode(),saveParam.getName());
    checkStudentInfo(studentInfoResp);
    StudentInfo studentInfoReq = StudentInfo.buildFromCreatParam(saveParam);
    return studentInfoMapper.updateStudentInfo(studentInfoReq);

  }

  /**d
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
