package com.blen.studentmanagesystem.controller;

import javax.validation.Valid;

import com.blen.studentmanagesystem.controller.req.StudentInfoCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentInfoRemoveParam;
import com.blen.studentmanagesystem.domain.StudentInfo;
import com.blen.studentmanagesystem.service.StudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentinfo")
@Api(value = "API-StudentInfoController", description = "接口")
@Validated
public class StudentInfoController {
  @Autowired
  private StudentInfoService studentInfoService ;

  @PostMapping("/add")
  @ApiOperation(value = "添加学生信息")
  public long addStudentInfo(
      @Valid @RequestBody StudentInfoCreateParam studentInfoCreateParam) {
    return  studentInfoService.addStudentInfo(studentInfoCreateParam);

  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除学生信息")
  public int deleteStudentInfo(
      @Valid @RequestBody StudentInfoRemoveParam removeParam) {
    return studentInfoService.deleteStudentInfo(removeParam);
  }

  @PostMapping("/update")
  @ApiOperation(value = "修改学生信息")
  public int updateStudentInfo(
      @Valid @RequestBody StudentInfoCreateParam studentInfoCreateParam) {

    return studentInfoService.updateStudentInfo(studentInfoCreateParam);
  }

  @GetMapping("/get")
  @ApiOperation(value = "查询学生信息")
  public StudentInfo getStudentInfo(
      @ApiParam(value = "学号code")
      @RequestParam(value = "code") Long code,

      @ApiParam(value = "姓名name")
      @RequestParam(value = "name") String name) {
    return studentInfoService.getStudentInfo(code, name);
  }


}
