package com.blen.singleobject;

public class HungrySingleton {
  private static HungrySingleton instance = new HungrySingleton();
  private HungrySingleton(){}

  public static HungrySingleton getInstance(){
    return instance;
  }
}
