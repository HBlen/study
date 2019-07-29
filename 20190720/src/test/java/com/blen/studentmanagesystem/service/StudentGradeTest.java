package com.blen.studentmanagesystem.service;

import com.blen.studentmanagesystem.StudentManageSystemApplicationTests;
import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.StudentGradeCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentGradeRemoveParam;
import com.blen.studentmanagesystem.domain.StudentGrade;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

@Slf4j
public class StudentGradeTest extends StudentManageSystemApplicationTests {

  @Autowired private StudentGradeService studentGradeService;

  /**
   * @testCase 1、验证添加数据: 添加一条数据,返回成功，1
   * @testCase 2、验证重复添加数据: 添加两条相同数据，返回1
   * @testCase 3、验证输出日志: 添加异常数据
   */
  @Test
  public void add_grade() {
    StudentGradeCreateParam createParam =
        StudentGradeCreateParam.builder()
            .code(100L)
            .name("han")
            .year(2001)
            .math(100)
            .english(100)
            .chinese(100)
            .build();
    Long id = studentGradeService.addStudentGrade(createParam);
    assertTrue(id > 0);
  }

  @Test
  public void add_grade_ex() {
    StudentGradeCreateParam createParam =
        StudentGradeCreateParam.builder()
            .code(200L)
            .name("zhang")
            .year(2001)
            .math(100)
            .english(100)
            .chinese(100)
            .build();
    studentGradeService.addStudentGrade(createParam);

    Long id = studentGradeService.addStudentGrade(createParam);
    assertTrue(id > 0);

  }

  @Test
  public void add_grade_exception(){
    StudentGradeCreateParam createParam=
        StudentGradeCreateParam.builder()
            .code(100L)
            .name("hanzhzhzhhhzhzhzhhzhzhzhzhzhhzhzhzhzhuhuhuhuhuhuhuh")
            .year(2001)
            .math(100)
            .english(100)
            .chinese(100)
            .build();

        try{
          studentGradeService.addStudentGrade(createParam);
        }catch (ApiException e){
          assertTrue(e.getErrorCode() == StudentManageErrorEnum.SYSTEM_INTERNAL_ERROR.getCode());
        }
  }


  /**
   * @testCase 1、验证删除存在的数据: 添加一条数据，然后删除
   * @testCase 1、验证删除不存在的数据，报异常: 删除不存在的数据
   */
  @Test
  public void delete_grade() {

    StudentGradeCreateParam createParam =
        StudentGradeCreateParam.builder()
            .code(400L)
            .name("ding")
            .year(2001)
            .math(100)
            .english(100)
            .chinese(100)
            .build();
    studentGradeService.addStudentGrade(createParam);

    StudentGradeRemoveParam removeParam = StudentGradeRemoveParam.builder()
        .code(400L)
        .year(2001)
        .build();
    int resp1 = studentGradeService.deleteStudentGrade(removeParam);
    assertTrue(resp1 > 0);
  }

  @Test
  public void delete_grade_non() {

    StudentGradeRemoveParam removeParam = StudentGradeRemoveParam.builder()
        .code(500L)
        .year(2001)
        .build();
    try {
      studentGradeService.deleteStudentGrade(removeParam);
    } catch (ApiException e) {
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.DUPLICATE_DATA.getCode());
    }
  }

  /**
   * @testCase 1、验证更新数据，数据存在。先添加一条数据，然后再更新
   * @testCase 2、验证更新数据，数据不存在，报异常。直接更新不存在的数据
   */
  @Test
  public void update_grade() {

    StudentGradeCreateParam createParamAdd =
        StudentGradeCreateParam.builder()
            .code(600L)
            .name("du")
            .year(2001)
            .math(100)
            .english(100)
            .chinese(100)
            .build();
    studentGradeService.addStudentGrade(createParamAdd);

    StudentGradeCreateParam createParamUpdate =
        StudentGradeCreateParam.builder()
            .code(600L)
            .name("du")
            .year(2001)
            .math(90)
            .english(90)
            .chinese(90)
            .build();
    int resp = studentGradeService.updateStudentGrade(createParamUpdate);
    assertTrue(resp == 1);
  }

  @Test
  public void update_grade_non() {
    StudentGradeCreateParam createParamUpdate =
        StudentGradeCreateParam.builder()
            .code(700L)
            .name("du")
            .year(2001)
            .math(100)
            .english(100)
            .chinese(100)
            .build();
    try {
      studentGradeService.updateStudentGrade(createParamUpdate);
    } catch (ApiException e) {
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.DUPLICATE_DATA.getCode());
    }
  }

  /**
   * @testCase 1、验证查找数据，数据存在。先添加数据，然后查找
   * @testCase 2、验证查找数据，数据不存在。直接查找不存在的数据
   */
  @Test
  public void get_grade() {

    StudentGrade studentGradeResp = studentGradeService.getStudentGrade(600L, 2001);
    assertTrue(600L == studentGradeResp.getCode());
  }

  @Test
  public void get_grade_non() {
    try {
      studentGradeService.getStudentGrade(800L, 2019);
    } catch (ApiException e) {
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.DUPLICATE_DATA.getCode());
    }
  }
}
