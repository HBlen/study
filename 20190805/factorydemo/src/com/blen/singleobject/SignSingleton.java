package com.blen.singleobject;

import java.time.Period;

import javax.net.ssl.SSLContext;

public class SignSingleton {
  private static class  SingletonHolder{
    private static final SignSingleton INSTANCE = new SignSingleton();
  }
  private SignSingleton(){}
  public static final SignSingleton getInstance(){
    return SingletonHolder.INSTANCE;
  }

}
