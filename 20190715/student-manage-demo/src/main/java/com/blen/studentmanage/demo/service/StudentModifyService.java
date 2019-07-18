package com.blen.studentmanage.demo.service;

import com.blen.studentmanage.demo.dao.StudentModifyDao;
import com.blen.studentmanage.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentModifyService {
  @Autowired
  private  StudentModifyDao studentModifyDao;

  /**
   * 添加学生
   * @param student 学生信息
   */

  public void addStudent(Student student) {
    studentModifyDao.addStudent(student);
  }

  /**
   * 根据id删除学生
   *
   * @param id 学生id
   */
  public void deleteStudent(long id) {
    studentModifyDao.deleteStudent(id);
  }

  /**
   * 更新学生信息
   *
   * @param student
   */
  public void updateStudent(Student student) {
    studentModifyDao.updateStudent(student);
  }

  /**
   * 根据id查找学生信息
   *
   * @param id
   * @return
   */
  public Student getStudent(long id) {
    return studentModifyDao.getStudent(id);
  }
}
