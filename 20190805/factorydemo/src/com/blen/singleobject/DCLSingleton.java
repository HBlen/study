package com.blen.singleobject;

public class DCLSingleton {

  private volatile static DCLSingleton singleton;

  private DCLSingleton() {}

  public static DCLSingleton getDclSingleton() {
    if (singleton == null) {
      synchronized (DCLSingleton.class) {
        if (singleton == null) {
          singleton = new DCLSingleton();
        }
      }
    }
    return singleton;
  }
}
