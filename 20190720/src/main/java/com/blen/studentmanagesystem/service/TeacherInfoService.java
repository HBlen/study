package com.blen.studentmanagesystem.service;

import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.TeacherInfoCreatParam;
import com.blen.studentmanagesystem.dao.TeacherInfoMapper;
import com.blen.studentmanagesystem.domain.TeacherInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeacherInfoService {

  @Autowired
  private TeacherInfoMapper teacherInfoMapper;

  /**
   * 校验数据是否存在
   * @param teacherInfo
   */
  private void checkTeacherInfo(TeacherInfo teacherInfo) {
    if (teacherInfo == null) {
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }
  }

  /**
   * 添加教师
   * @param param  教师信息
   */

  public long addTeacherInfo(TeacherInfoCreatParam param) {
    TeacherInfo teacherInfo = TeacherInfo.builder()
        .code(param.getCode())
        .name(param.getName())
        .sex(param.getSex())
        .age(param.getAge())
        .classname(param.getClassname())
        .build();
    try {
      teacherInfoMapper.addTeacherInfo(teacherInfo);
    } catch (DuplicateKeyException e) {
      return teacherInfoMapper.getTeacherInfo(param.getCode(),param.getName()).getId();
    } catch (Exception e) {
      log.error("addTeacherInfo exception:{} ", teacherInfo.toString(), e);
      throw new ApiException(StudentManageErrorEnum.DUPLICATE_DATA);
    }
    return teacherInfo.getId();
  }

  /**
   * 根据编号删除教师
   *
   * @param code 教师编号
   */
  public int  deleteTeacherInfo(Long code, String name) {
    TeacherInfo teacherInfoResp = teacherInfoMapper.getTeacherInfo(code, name);
    checkTeacherInfo(teacherInfoResp);
    return teacherInfoMapper.deleteTeacherInfo(code,name);
  }

  /**
   * 更新教师信息
   *
   * @param param 教师信息
   */
  public int updateTeacherInfo(TeacherInfoCreatParam param) {

    TeacherInfo teacherInfoResp = teacherInfoMapper.getTeacherInfo(param.getCode(),param.getName());
    checkTeacherInfo(teacherInfoResp);
    TeacherInfo teacherInfoReq = TeacherInfo.builder()
        .code(param.getCode())
        .name(param.getName())
        .sex(param.getSex())
        .age(param.getAge())
        .classname(param.getClassname())
        .build();
    return teacherInfoMapper.updateTeacherInfo(teacherInfoReq);

  }

  public TeacherInfo  getTeacherInfo(Long code, String name) {
    TeacherInfo teacherInfoResp = teacherInfoMapper.getTeacherInfo(code, name);
    checkTeacherInfo(teacherInfoResp);
    return teacherInfoResp;
  }
//TODO:
//  public String  loginTeacher(Long code, String password) {
//    TeacherInfo teacherInfo = teacherInfoMapper.loginTeacher(code, password);
//    if(teacherInfo == null){
//      return "编号或密码错误";
//       }
//    return "teacher[code: " + teacherInfo.getCode()+", name: " + teacherInfo.getName() + ", classname: " + teacherInfo.getClassname() + "]";
//  }
}
