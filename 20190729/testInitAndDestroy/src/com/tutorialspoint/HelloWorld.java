package com.tutorialspoint;

public class HelloWorld {
  private String message;

  public void setMessage(String message){
    this.message  = message;
  }
  public void getMessage(){
    System.out.println("Your Message : " + message);
  }
  public void init(){
    System.out.println("Bean is gonging through init.");
  }
  public void destroy(){
    System.out.println(("Bean will destroy now."));
  }

}
