package com.blen.student_manage_system.controller;

import javax.validation.Valid;

import com.blen.student_manage_system.dao.TeacherInfoMapper;
import com.blen.student_manage_system.domain.TeacherInfo;
import com.blen.student_manage_system.service.TeacherInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/get")
  @ApiOperation(value = "查询教师信息")
  public TeacherInfo getTeacherInfo(@RequestParam(value = "t_code") long t_code,
      @RequestParam(value = "t_name") String  t_name) {
    return teacherInfoService.getTeacherInfo(t_code,t_name);
  }


  @GetMapping("/login")
  @ApiOperation(value = "教师登录")
  public String loginTeacher(@RequestParam(value = "t_code") long t_code,
      @RequestParam(value = "password") String  password) {
    return teacherInfoService.loginTeacher(t_code,password);
  }


}
