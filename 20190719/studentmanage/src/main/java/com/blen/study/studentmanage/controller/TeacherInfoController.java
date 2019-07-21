package com.blen.study.studentmanage.controller;

import javax.validation.Valid;

import com.blen.study.studentmanage.dao.TeacherInfoMapper;
import com.blen.study.studentmanage.domain.TeacherInfo;
import com.blen.study.studentmanage.service.TeacherInfoService;
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
  public TeacherInfo getTeacherInfo(@RequestParam(value = "t_code") long t_code) {
    return teacherInfoService.getTeacherInfo(t_code);
  }

}
