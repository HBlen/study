package com.blen.studentmanagesystem.common.enums;

import com.blen.studentmanagesystem.common.ErrorCode;

public enum StudentManageErrorEnum implements ErrorCode {


  DUPLICATE_DATA(-400001, "the data is existed"),
  SYSTEM_INTERNAL_ERROR(-1005,"system error");

  private final int code;
  private final String desc;

  StudentManageErrorEnum(int code, String desc) {
    this.code = code;
    this.desc = desc;
    }

  public static StudentManageErrorEnum get(int code) {
    for (StudentManageErrorEnum errorEnum : StudentManageErrorEnum.values()) {
    if (errorEnum.getCode() == code) {
    return errorEnum;
    }
    }
    return null;
    }

  @Override
  public int getCode() {
    return code;
    }

  @Override
  public String getDesc() {
    return desc;
    }

}
