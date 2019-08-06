package com.blen.singleobject;

public class SingleObject {

  //创建一个对象
  private static SingleObject instance = new SingleObject();

  //设置构造函数为private ，防止类被实例化
  private SingleObject(){}

  //获取唯一可用对象
  public static SingleObject getInstance(){
    return instance;
  }

  public void ShowMessage(){
    System.out.println("Hello Huo");
  }
}
