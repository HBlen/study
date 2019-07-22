package com.blen.student_manage_system.controller;

import com.blen.student_manage_system.domain.StudentGrade;
import com.blen.student_manage_system.service.StudentGradeService;
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
      @RequestParam(value = "s_code") Long s_code,
      @RequestParam(value = "s_name") String s_name,
      @RequestParam(value = "g_year") Integer g_year,
      @RequestParam(value = "g_math", required = false) double g_math,
      @RequestParam(value = "g_english", required = false) double g_english,
      @RequestParam(value = "g_chinese", required = false) double g_chinese ) {

    return studentGradeService.addStudentGrade(s_code,s_name,g_year,g_math,g_english,g_chinese);
  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除学生成绩")
  public String deleteStudentGrade(
      @RequestParam(value = "s_code") Long s_code,
      @RequestParam(value = "g_year") Integer g_year) {
    return studentGradeService.deleteStudentGrade(s_code,g_year);
  }

  @PostMapping("/update")
  @ApiOperation(value = "修改学生成绩")
  public int updateStudentGrade(
      @RequestParam(value = "s_code") Long s_code,
      @RequestParam(value = "s_name") String s_name,
      @RequestParam(value = "g_year") Integer g_year,
      @RequestParam(value = "g_math", required = false) double g_math,
      @RequestParam(value = "g_english", required = false) double g_english,
      @RequestParam(value = "g_chinese", required = false) double g_chinese ) {

    return studentGradeService.updateStudentGrade(s_code,s_name,g_year,g_math,g_english,g_chinese);
  }

  @GetMapping("/get")
  @ApiOperation(value = "查询学生成绩")
  public StudentGrade getStudentInfo(@RequestParam(value = "s_code") Long s_code,
      @RequestParam(value = "g_year") Integer g_year) {
    return studentGradeService.getStudentGrade(s_code,g_year);
  }

//  @GetMapping("/list")
//  @ApiOperation(value = "按表查询学生信息")
//  public List<StudentInfo> listStudentInfo(
//      @RequestParam(value = "start") long start,
//      @RequestParam(value = "count") long count){
//    return studentInfoService.listStudentInfo(start,count);
//  }

}
