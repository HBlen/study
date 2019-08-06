package com.blen.singleobject;

public class LazySingleton2 {

  private static LazySingleton2 instance;

  private LazySingleton2() {}

  public static synchronized LazySingleton2 getInstance() {
    if (instance == null) {
      instance = new LazySingleton2();
    }
    return instance;
  }
}
