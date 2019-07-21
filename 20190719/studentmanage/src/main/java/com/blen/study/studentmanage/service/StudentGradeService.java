package com.blen.study.studentmanage.service;


import com.blen.study.studentmanage.dao.StudentGradeMapper;
import com.blen.study.studentmanage.domain.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentGradeService {
  @Autowired
  private StudentGradeMapper studentGradeMapper;

  /**
   * 添加学生成绩
   * @param studentGradeParam  学生信息
   */

  public long addStudentGrade(Long s_code,
      String s_name,
      Integer g_year,
      Double g_math,
      Double g_english,
      Double g_chinese){
    StudentGrade studentGrade = StudentGrade.builder()
        .s_code(s_code)
        .s_name(s_name)
        .g_year(g_year)
        .g_math(g_math)
        .g_english(g_english)
        .g_chinese(g_chinese)
        .build();


    return studentGradeMapper.addStudentGrade(studentGrade);
  }

  /**
   * 根据学号和学年删除学生成绩
   *
   * @param s_code 学生学号
   * @param g_year 学年
   */
  public String  deleteStudentGrade(Long s_code,Integer g_year) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(s_code,g_year);
    if(studentGradeResp == null){
      return "无该学号学生";
    }
    studentGradeMapper.deleteStudentGrade(s_code,g_year);
    return "deleted";
  }

  /**
   * 更新学生信息
   *
   */
  public int updateStudentGrade(Long s_code,
      String s_name,
      Integer g_year,
      Double g_math,
      Double g_english,
      Double g_chinese) {
    StudentGrade studentGradeResp = studentGradeMapper.getStudentGrade(s_code, g_year);
    if(studentGradeResp == null){
      return 404;
    }

    StudentGrade studentGradeReq = StudentGrade.builder()
        .s_code(s_code)
        .s_name(s_name)
        .g_year(g_year)
        .g_math(g_math)
        .g_english(g_english)
        .g_chinese(g_chinese)
        .build();
    return studentGradeMapper.updateStudentGrade(studentGradeReq);

  }

  /**
   * 根据id查找学生信息
   *
   * @param s_code 学生学号
   * @return StudentGrade学生信息
   */
  public StudentGrade  getStudentGrade(Long s_code,Integer g_year) {

    return studentGradeMapper.getStudentGrade(s_code,g_year);
  }
//
//  public List<StudentGrade> listStudentGrade(long start,long count){
//    List<StudentGrade> studentGradeList = studentGradeMapper.listStudentGrade(start, count);
//    if (CollectionUtils.isEmpty(studentGradeList)) {
//      return Collections.emptyList();
//    }
//    return studentGradeList;
//  }
}
