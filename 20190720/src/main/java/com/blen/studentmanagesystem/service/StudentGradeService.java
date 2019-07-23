package com.blen.studentmanagesystem.service;


import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
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
   * @param studentInfo
   */
  private void checkStudentGrade(StudentGrade studentGrade) {
    if (studentGrade == null) {
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }
  }
  /**
   * 添加学生成绩
   * @param 学生信息
   */

  public long addStudentGrade(Long code,
      String name,
      Integer year,
      Double math,
      Double english,
      Double chinese){
    StudentGrade studentGrade = StudentGrade.builder()
        .code( code )
        .name( name )
        .year( year )
        .math( math )
        .english( english )
        .chinese( chinese )
        .build();

    try {
      studentGradeMapper.addStudentGrade(studentGrade);
    } catch (DuplicateKeyException e) {
      return studentGradeMapper.getStudentGrade(code, year).getId();
    } catch (Exception e) {
      log.error("addStudentInfo exception:{} ", studentGrade.toString(), e);
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }

    return studentGrade.getId();
  }

  /**
   * 根据学号和学年删除学生成绩
   *
   * @param code 学生学号
   * @param year 学年
   */

  public int  deleteStudentGrade(Long code, Integer year) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(code, year);
    checkStudentGrade(studentGradeResp);
    return studentGradeMapper.deleteStudentGrade(code, year);
  }

  /**
   * 更新学生信息
   *
   */
  public int updateStudentGrade(Long code,
      String name,
      Integer year,
      Double math,
      Double english,
      Double chinese) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(code, year);
    checkStudentGrade(studentGradeResp);

    StudentGrade studentGradeReq = StudentGrade.builder()
        .code( code )
        .name( name )
        .year( year)
        .math( math)
        .english(english)
        .chinese(chinese)
        .build();
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
