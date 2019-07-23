package com.blen.studentmanagesystem.controller;

import javax.validation.Valid;

import com.blen.studentmanagesystem.controller.req.TeacherInfoCreatParam;
import com.blen.studentmanagesystem.domain.TeacherInfo;
import com.blen.studentmanagesystem.service.TeacherInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacherinfo")
@Api(value = "API-TeacherInfoController", description = "接口")
@Valid
public class TeacherInfoController {

  @Autowired
  private TeacherInfoService teacherInfoService;


  @PostMapping("/add")
  @ApiOperation(value = "添加教师信息")
  public long addTeacherInfo(
      @Valid @RequestBody TeacherInfoCreatParam teacherInfoCreatParam) {
    return  teacherInfoService.addTeacherInfo(teacherInfoCreatParam);

  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除教师信息")
  public int deleteTeacherInfo(
      @RequestParam(value = "code") Long code,
      @RequestParam(value = "name") String name) {
    return teacherInfoService.deleteTeacherInfo(code, name);
  }

  @PostMapping("/update")
  @ApiOperation(value = "修改教师信息")
  public int updateTeacherInfo(
      @Valid @RequestBody TeacherInfoCreatParam teacherInfoCreatParam) {

    return teacherInfoService.updateTeacherInfo(teacherInfoCreatParam);
  }
  @GetMapping("/get")
  @ApiOperation(value = "查询教师信息")
  public TeacherInfo getTeacherInfo(@RequestParam(value = "code") long code,
      @RequestParam(value = "name") String  name) {
    return teacherInfoService.getTeacherInfo(code, name);
  }

//TODO
//  @GetMapping("/login")
//  @ApiOperation(value = "教师登录")
//  public String loginTeacher(@RequestParam(value = "code") long code,
//      @RequestParam(value = "password") String  password) {
//    return teacherInfoService.loginTeacher(code,password);
//  }


}
