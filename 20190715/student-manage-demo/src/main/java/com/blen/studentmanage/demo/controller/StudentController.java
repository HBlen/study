package com.blen.studentmanage.demo.controller;

import com.blen.studentmanage.demo.domain.Student;
import com.blen.studentmanage.demo.service.StudentModifyService;
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
@RequestMapping("/student")
@Api(value = "API-StudentController", description = "接口")
@Validated
public class StudentController {
  @Autowired
  private StudentModifyService studentModifyService;// = new StudentModifyService();

  @GetMapping("/hello")
  public String sayHello() {
    return "hello world";
  }

  @PostMapping("/add")
  @ApiOperation(value = "添加学生")
  public Long addStudent(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "sex") String sex,
      @RequestParam(value = "age") int age,
      @RequestParam(value = "major", required = false) String major,
      @RequestParam(value = "grade", required = false) double grade) {

    Student student =
        new Student(name, sex, age, major, grade); // "zhangsan","female",19,1302,"science",9);

    studentModifyService.addStudent(student);
    return student.getId();
  }

  @PostMapping("/delete")
  @ApiOperation(value = "删除学生信息")
  public String deleteStudent(@RequestParam(value = "id") long id) {

    studentModifyService.deleteStudent(id);
    return "deleted";

  }

  @PostMapping("/update")
  @ApiOperation(value = "修改学生信息")
  public String updateStudent(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "sex") String sex,
      @RequestParam(value = "age") int age,
      @RequestParam(value = "id") long id,
      @RequestParam(value = "major", required = false) String major,
      @RequestParam(value = "grade", required = false) double grade) {

    Student student = new Student(name, sex, age, major, grade,id);
    studentModifyService.updateStudent(student);
    return "updated";
  }

  @GetMapping("/get")
  @ApiOperation(value = "查询学生信息")
  public Student getStudent(@RequestParam(value = "id") long id) {
    Student student = studentModifyService.getStudent(id);
    if (student == null) return null;
    else return student;
  }
}
