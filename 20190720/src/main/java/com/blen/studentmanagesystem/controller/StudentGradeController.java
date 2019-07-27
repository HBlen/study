package com.blen.studentmanagesystem.controller;

import com.blen.studentmanagesystem.controller.req.StudentGradeCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentGradeRemoveParam;
import com.blen.studentmanagesystem.domain.StudentGrade;
import com.blen.studentmanagesystem.service.StudentGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      @Validated @RequestBody StudentGradeCreateParam createParam) {
    return studentGradeService.addStudentGrade( createParam);
  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除学生成绩")
  public int deleteStudentGrade(
      @Validated @RequestBody StudentGradeRemoveParam removeParam) {
    return studentGradeService.deleteStudentGrade( removeParam );
  }

  @PostMapping("/update")
  @ApiOperation(value = "修改学生成绩")
  public int updateStudentGrade(
      @Validated @RequestBody StudentGradeCreateParam createParam) {

    return studentGradeService.updateStudentGrade(createParam);
  }

  @GetMapping("/get")
  @ApiOperation(value = "查询学生成绩")
  public StudentGrade getStudentInfo(@RequestParam(value = "code") Long code,
      @RequestParam(value = "year") Integer year) {
    return studentGradeService.getStudentGrade( code, year);
  }

}
