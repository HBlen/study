package com.blen.studentmanagesystem.service;

import com.blen.studentmanagesystem.common.enums.StudentManageErrorEnum;
import com.blen.studentmanagesystem.common.exception.ApiException;
import com.blen.studentmanagesystem.controller.req.TeacherInfoCreateParam;
import com.blen.studentmanagesystem.controller.req.TeacherInfoRemoveParam;
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
     * @param saveParam 教师信息
     */

    public long addTeacherInfo(TeacherInfoCreateParam saveParam) {
      TeacherInfo teacherInfo = TeacherInfo.buildFromCreatParam(saveParam);

      try {
       return teacherInfoMapper.addTeacherInfo(teacherInfo);
      } catch (DuplicateKeyException e) {
        return teacherInfoMapper.getTeacherInfo(saveParam.getCode(),saveParam.getName()).getId();
      } catch (Exception e) {
        log.error("addTeacherInfo exception:{} ", saveParam.toString(), e);
        throw new ApiException(StudentManageErrorEnum.SYSTEM_INTERNAL_ERROR);
      }

    }

    /**
     * 根据id删除教师
     *
     * @param removeParam 教师学号
     */
    public int  deleteTeacherInfo(TeacherInfoRemoveParam removeParam ) {
      TeacherInfo teacherInfoResp = teacherInfoMapper.getTeacherInfo(removeParam.getCode(),removeParam.getName());
      checkTeacherInfo(teacherInfoResp);

      return teacherInfoMapper.deleteTeacherInfo(removeParam);
    }

    /**
     * 更新教师信息
     *
     * @param removeParam 教师信息
     */
    public int updateTeacherInfo(TeacherInfoCreateParam saveParam) {
      TeacherInfo teacherInfoResp = teacherInfoMapper.getTeacherInfo(saveParam.getCode(),saveParam.getName());
      checkTeacherInfo(teacherInfoResp);
      TeacherInfo teacherInfoReq = TeacherInfo.buildFromCreatParam(saveParam);
      return teacherInfoMapper.updateTeacherInfo(teacherInfoReq);

    }

    /**d
     * 根据id查找教师信息
     *
     * @param code 教师学号
     * @param name 姓名
     * @return TeacherInfo 教师信息
     */
    public TeacherInfo  getTeacherInfo(Long code, String name) {
      TeacherInfo teacherInfoResp = teacherInfoMapper.getTeacherInfo(code, name);
      checkTeacherInfo(teacherInfoResp);
      return teacherInfoResp;
    }

  }
