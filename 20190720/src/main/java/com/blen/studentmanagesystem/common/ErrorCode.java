package com.blen.studentmanagesystem.common;

import com.blen.studentmanagesystem.common.i18n.LocalMessageResource;

public interface ErrorCode {

  int getCode();

  /**
   * Get error code as String.
   *
   * @return Error code like "gateway-url-notfound"
   */
  String getDesc();

  /**
   * Get error message for debug purpose.
   *
   * @return Debug message like "Requested URL not found"
   */
  default String getErrMsg() {
    return LocalMessageResource.getMessage(String.valueOf(getCode()));
  }

  default String getErrMsg(Object... args) {
    return LocalMessageResource.getMessage(String.valueOf(getCode()), args);
  }
}
