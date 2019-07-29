package com.blen.studentmanagesystem.common.exception;


import com.blen.studentmanagesystem.common.ErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

  /**
   * 错误码.
   */
  private final ErrorCode errorCode;

  public int getErrorCode() {
    return errorCode.getCode();
  }

  /**
   * ErrorCode
   */
  public ApiException(ErrorCode errorCode) {
    super(errorCode.getErrMsg());
    this.errorCode = errorCode;
  }

  /**
   * ErrorCode with params
   */
  public ApiException(ErrorCode errorCode, Object... params) {
    super(errorCode.getErrMsg(params));
    this.errorCode = errorCode;
  }


  /**
   * Throwable
   */
  public ApiException(ErrorCode errorCode, Throwable t) {
    super(t);
    this.errorCode = errorCode;
  }

}
