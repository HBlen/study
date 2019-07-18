//package com.blen.studentmanage.demo.service;
//
//import com.blen.studentmanage.demo.DemoApplicationTests;
//import com.blen.studentmanage.demo.domain.Student;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static junit.framework.TestCase.assertTrue;
//
//public class StudentModifyServiceTests extends DemoApplicationTests {
////  @Autowired
////  private StudentModifyService studentModifyService;
//    StudentModifyService studentModifyService = new StudentModifyService();
//
//  Student builde_student_data(
//      String name, String sex, int age, long id, String major, double grade) {
//    return new Student(name, sex, age, id, major, grade);
//  }
//  /**
//   * @testCase 1. 学生数据添加
//   * @testCase 2. 数据查找，按照id查找
//   * @testCase 3. 验证查找的是否正确
//   */
//  @Test
//  public void add_student_data() {
//    Student student = builde_student_data("zhangsan", "female", 19, 1302, "science", 90);
//    studentModifyService.addStudent(student);
//    String name = "zhangsan";
//    Student getStudent = studentModifyService.getStudent(1302);
//    assertTrue(name == getStudent.getName());
//  }
//
//  /** @testCase 1.数据修改 */
//  @Test
//  public void update_student_data() {
//    Student student = builde_student_data("zhangsan", "female", 19, 1302, "science", 90);
//    studentModifyService.addStudent(student);
//    Student updateStudent = builde_student_data("lisi", "female", 19, 1302, "science", 90);
//    studentModifyService.updateStudent(updateStudent);
//
//    String name = "lisi";
//    Student getStudent = studentModifyService.getStudent(1302);
//    assertTrue(name == getStudent.getName());
//  }
//
//  /** @testCase 1. 删除数据 */
//  @Test
//  public void detete_student_data() {
//    Student student1 = builde_student_data("lisi", "male", 20, 1301, "science", 95);
//    studentModifyService.addStudent(student1);
//
//    Student student2 = builde_student_data("zhangsan", "female", 19, 1302, "science", 90);
//    studentModifyService.addStudent(student2);
//
//    // 先查看数据有没有添加成功
//    String name1 = "lisi";
//    Student getStudent1 = studentModifyService.getStudent(1301);
//    assertTrue(name1 == getStudent1.getName());
//
//    String name2 = "zhangsan";
//    Student getStudent2 = studentModifyService.getStudent(1302);
//    assertTrue(name2 == getStudent2.getName());
//
//    // 删除数据
//    studentModifyService.deleteStudent(1301);
//    Student getStudent3 = studentModifyService.getStudent(1301);
//    assertTrue(getStudent3 == null);
//  }
//}
