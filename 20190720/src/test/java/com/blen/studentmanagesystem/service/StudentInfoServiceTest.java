package com.blen.studentmanagesystem.service;

import com.blen.studentmanagesystem.StudentManageSystemApplicationTests;
import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.StudentInfoCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentInfoRemoveParam;
import com.blen.studentmanagesystem.domain.StudentInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

@Slf4j

public class StudentInfoServiceTest extends StudentManageSystemApplicationTests {

  @Autowired
  private StudentInfoService studentInfoService;

  /**
   * @testCase 1、验证添加数据: 添加一条数据,返回成功，1
   * @testCase 2、验证重复添加数据: 添加两条相同数据，返回1
   * @testCase 3、验证输出日志: 添加异常数据
   */

  @Test
  public void add_student(){

   StudentInfoCreateParam creatParamAdd = StudentInfoCreateParam.builder()
          .code(100L)
          .name("han")
          .sex("female")
          .age(26)
          .classname("yiban")
          .build();

    Long id = studentInfoService.addStudentInfo(creatParamAdd);
    assertTrue(id >0);
  }

  @Test
  public  void add_student_ex(){
    StudentInfoCreateParam creatParamAdd = StudentInfoCreateParam.builder()
        .code(0423L)
        .name("han")
        .sex("female")
        .age(26)
        .classname("yiban")
        .build();

    Long id = studentInfoService.addStudentInfo(creatParamAdd);
    assertTrue(id >0);
  }

  @Test
  public  void add_student_exception(){

    StudentInfoCreateParam creatParamException= StudentInfoCreateParam.builder()
          .code(0423L)
          .name("hanhuhuhuhuhuhuhouuhuhuhuhuhdonggygyghbhuyuhugywoihhbbhjybaijijibningdfafae")
          .sex("female")
          .age(26)
          .classname("yiban")
          .build();

    //输出日志
    try{
      studentInfoService.addStudentInfo(creatParamException);
    }catch (ApiException e){
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.SYSTEM_INTERNAL_ERROR.getCode());
    }
  }



  /**
   * @testCase 1、验证删除存在的数据: 添加一条数据，然后删除
   * @testCase 2、验证删除不存在的数据，报异常: 删除不存在的数据
   *
   */


  @Test
  public void delete_Student_info(){

    StudentInfoRemoveParam removeParam = StudentInfoRemoveParam.builder()
          .code(0423L)
          .name("han")
          .build();
    int resp1 = studentInfoService.deleteStudentInfo(removeParam);
    assertTrue(resp1>0);
  }

  @Test
  public void delete_Student_info_non(){
    StudentInfoRemoveParam removeParamNon = StudentInfoRemoveParam.builder()
        .code(04123L)
        .name("haen")
        .build();
    try {
      studentInfoService.deleteStudentInfo(removeParamNon);
    } catch (ApiException e) {
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.DUPLICATE_DATA.getCode());
    }

  }

  /**
   * @testCase 1、验证更新数据，数据存在。先添加一条数据，然后再更新
   * @testCase 2、验证更新数据，数据不存在，报异常。直接更新不存在的数据
   */
  @Test
  public void update_student_info(){

    StudentInfoCreateParam creatParamAdd = StudentInfoCreateParam.builder()
        .code(600L)
        .name("han")
        .sex("female")
        .age(26)
        .classname("yiban")
        .build();
   studentInfoService.addStudentInfo(creatParamAdd);

    StudentInfoCreateParam creatParamUpdate = StudentInfoCreateParam.builder()
          .code(600L)
          .name("han")
          .sex("female")
          .age(27)
          .classname("yieeban")
          .build();

    int resp = studentInfoService.updateStudentInfo(creatParamUpdate);
    assertTrue(resp>0);
  }

  @Test
  public void update_student_info_non(){
    StudentInfoCreateParam creatParamUpdateNon = StudentInfoCreateParam.builder()
        .code(700L)
        .name("hanz")
        .sex("female")
        .age(27)
        .classname("yieeban")
        .build();

    try{
      studentInfoService.updateStudentInfo(creatParamUpdateNon);
    }catch (ApiException e){
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.DUPLICATE_DATA.getCode());
    }
  }

  /**
   * @testCase 1、验证查找数据，数据存在。先添加数据，然后查找
   * @testCase 1、验证查找数据，数据不存在。直接查找不存在的数据
   */
  @Test
  public void get_student_info(){
    StudentInfoCreateParam creatParamAdd = StudentInfoCreateParam.builder()
        .code(800L)
        .name("han")
        .sex("female")
        .age(26)
        .classname("yiban")
        .build();
    studentInfoService.addStudentInfo(creatParamAdd);

    StudentInfo studentInfoResp = studentInfoService.getStudentInfo(800L,"han");
    assertTrue(800L == studentInfoResp.getCode());
  }

  @Test
  public void get_student_info_non(){
    try{
      studentInfoService.getStudentInfo(900L,"test-7");
    }catch (ApiException e){
      assertTrue(e.getErrorCode() == StudentManageErrorEnum.DUPLICATE_DATA.getCode());
    }
  }
}
