package com.blen.studentmanage.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.blen.studentmanage.demo.domain.Student;
import com.blen.studentmanage.demo.service.StudentModifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
@Api(value = "API-StudentController", description = "接口")
@Validated
public class StudentController {

  private StudentModifyService studentModifyService = new StudentModifyService();


  @GetMapping("/hello")
  public String sayHello(){
    return "hello world";
  }


  /*
  public String addStudent(
      @RequestParam("name") String name,
      @RequestParam("sex") String sex,
      @RequestParam("age") Integer age,
      @RequestParam("id") Long id,
      @RequestParam("major") String major,
      @RequestParam("grade") Double grade)

      {

   // Student student = new Student(name, sex, age, id, major, grade); "zhangsan","female",19,1302,"science",90
    Student student = new Student("zhangsan","female",19,1302,"science",90);
    studentModifyService.addStudent(student);
    return studentModifyService.getStudent(student.getId()).toString();
  }
  */
/*
  @RequestMapping("/add")
  public String addStudent(HttpServletRequest request)
  {
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    int age = Integer.parseInt(request.getParameter("age"));
    long id = Long.parseLong(request.getParameter("student_id"));
    String major = request.getParameter("major");
    double grade = Double.parseDouble(request.getParameter("grade"));

    Student student = new Student(name, sex, age, id, major, grade);// "zhangsan","female",19,1302,"science",9);

    studentModifyService.addStudent(student);
    return studentModifyService.getStudent(student.getId()).toString();
  }
*/

  @PostMapping("/add")
  @ApiOperation(value = "添加学生")
  public String addStudent(
      @RequestParam(value = "name") String name,

      @RequestParam(value = "sex")  String sex,

      @RequestParam(value = "age") int age,

      @RequestParam(value = "id")  long id,

      @RequestParam(value = "major", required = false)  String major,

      @RequestParam(value = "grade", required = false)  double grade)

  {
    Student student = new Student(name, sex, age, id, major, grade);// "zhangsan","female",19,1302,"science",9);
    Student student2 = new Student("zhangsan","female",19,1302,"science",9);

    studentModifyService.addStudent(student);
    studentModifyService.addStudent(student2);
    return studentModifyService.getStudent(student2.getId()).toString();
  }


  @PostMapping("/delete")
  @ApiOperation(value = "删除学生信息")
  public String deleteStudent(
      @RequestParam(value = "id") long id)

  {
   studentModifyService.deleteStudent(id);
    Student getStudent3 = studentModifyService.getStudent(id);
    if (getStudent3 == null)
      return "deleted";
    else
      return  "failed";

  }

  @PostMapping("/update")
  @ApiOperation(value = "修改学生信息")
  public String updateStudent(
      @RequestParam(value = "name") String name,

      @RequestParam(value = "sex")  String sex,

      @RequestParam(value = "age") int age,

      @RequestParam(value = "id")  long id,

      @RequestParam(value = "major", required = false)  String major,

      @RequestParam(value = "grade", required = false)  double grade)

  {
    Student student = new Student(name, sex, age, id, major, grade);
    studentModifyService.updateStudent(student);

    Student studentGet = studentModifyService.getStudent(id);
    if(name.equals(studentGet.getName()) )
      return "updated";
    else
        return "failed";

  }

  @GetMapping("/check")
  @ApiOperation(value = "查询学生信息")
  public String getStudent(
      @RequestParam(value = "id") long id)
  {
    Student student = studentModifyService.getStudent(id);
    if(student==null)
      return "failed";
    else
      return student.toString();
  }

}

