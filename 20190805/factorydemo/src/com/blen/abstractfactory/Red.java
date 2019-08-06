package com.blen.abstractfactory;

public class Red implements Color{
  @Override
  public void fill(){
    System.out.println("Inside red::fill() method");
  }
}
