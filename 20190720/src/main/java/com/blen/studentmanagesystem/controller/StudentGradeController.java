package com.blen.studentmanagesystem.controller;

import com.blen.studentmanagesystem.domain.StudentGrade;
import com.blen.studentmanagesystem.service.StudentGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
@Api(value = "API-StudentGradeController", description = "接口")
@Validated

public class StudentGradeController {
  @Autowired
  private StudentGradeService studentGradeService ;

  @PostMapping("/add")
  @ApiOperation(value = "添加学生成绩")
  public long addStudent(
      @RequestParam(value = "code") Long code,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "year") Integer year,
      @RequestParam(value = "math", required = false) double math,
      @RequestParam(value = "english", required = false) double english,
      @RequestParam(value = "chinese", required = false) double chinese ) {

    return studentGradeService.addStudentGrade( code, name, year, math, english, chinese);
  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除学生成绩")
  public int deleteStudentGrade(
      @RequestParam(value = " code") Long code,
      @RequestParam(value = " year") Integer year) {
    return studentGradeService.deleteStudentGrade( code, year);
  }

  @PostMapping("/update")
  @ApiOperation(value = "修改学生成绩")
  public int updateStudentGrade(
      @RequestParam(value = "code") Long code,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "year") Integer year,
      @RequestParam(value = "math", required = false) double math,
      @RequestParam(value = "english", required = false) double english,
      @RequestParam(value = "chinese", required = false) double chinese ) {

    return studentGradeService.updateStudentGrade(code, name, year, math, english, chinese);
  }

  @GetMapping("/get")
  @ApiOperation(value = "查询学生成绩")
  public StudentGrade getStudentInfo(@RequestParam(value = " code") Long code,
      @RequestParam(value = "year") Integer year) {
    return studentGradeService.getStudentGrade( code, year);
  }

}
