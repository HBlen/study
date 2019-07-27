package com.blen.studentmanagesystem.service;


import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.StudentGradeRemoveParam;
import com.blen.studentmanagesystem.controller.req.StudentGradeCreateParam;
import com.blen.studentmanagesystem.dao.StudentGradeMapper;
import com.blen.studentmanagesystem.domain.StudentGrade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentGradeService {
  @Autowired
  private StudentGradeMapper studentGradeMapper;

  /**
   * 校验数据是否存在
   * @param studentGrade
   */
  private void checkStudentGrade(StudentGrade studentGrade) {
    if (studentGrade == null) {
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }
  }

  /**
   * 添加学生成绩
   * @param saveParam 学生信息
   */

  public long addStudentGrade(StudentGradeCreateParam saveParam){
    StudentGrade studentGrade = StudentGrade.buildFromCreatParam(saveParam);

    try {
     return studentGradeMapper.addStudentGrade(studentGrade);
    } catch (DuplicateKeyException e) {
      return studentGradeMapper.getStudentGrade(saveParam.getCode(), saveParam.getYear()).getId();
    } catch (Exception e) {
      log.error("addStudentInfo exception:{} ", studentGrade.toString(), e);
      throw new ApiException(StudentManageErrorEnum.SYSTEM_INTERNAL_ERROR);
    }

  }

  /**
   * 根据学号和学年删除学生成绩
   *
   * @param removeParam 学生学号，学年
   */

  public int  deleteStudentGrade(StudentGradeRemoveParam removeParam) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(removeParam.getCode(),removeParam.getYear());
    checkStudentGrade(studentGradeResp);

    return studentGradeMapper.deleteStudentGrade(removeParam);
  }

  /**
   * 更新学生信息
   *
   */
  public int updateStudentGrade(StudentGradeCreateParam saveParam) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(saveParam.getCode(), saveParam.getYear());
    checkStudentGrade(studentGradeResp);

    StudentGrade studentGradeReq = StudentGrade.buildFromCreatParam(saveParam);
    return studentGradeMapper.updateStudentGrade(studentGradeReq);

  }

  /**
   * 根据id查找学生信息
   *
   * @param code 学生学号
   * @param year 学生学号
   * @return StudentGrade学生信息
   */
  public StudentGrade  getStudentGrade(Long code, Integer year) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(code, year);
    checkStudentGrade(studentGradeResp);
    return studentGradeResp;
  }
//
//  public List<StudentGrade> listStudentGrade(long start,long count){
//    List<StudentGrade> studentGradeList = studentGradeMapper.listStudentGrade(start, count);
//    if (CollectionUtils.isEmpty(studentGradeList)) {
//      return Collections.emptyList();
//    }
//    return studentGradeList;
//  }
}
