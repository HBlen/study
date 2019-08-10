package com.blen.aop.aspect;

import sun.jvm.hotspot.debugger.cdbg.Sym;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Broker {

  /**
   * @Before ,@After
   */
//  @Before("execution(* com.blen.aop.pojo.Landlord.service())")
//  public void before(){
//    System.out.println("带租客看房");
//    System.out.println("谈价格");
//  }
//
//  @After("execution(* com.blen.aop.pojo.Landlord.service())")
//  public void after(){
//    System.out.println("交钥匙");
//  }

  //@Around
  @Around("execution(* com.blen.aop.pojo.Landlord.service())")
  public void around(ProceedingJoinPoint joinPoint){
    System.out.println("带租客看房");
    System.out.println("谈价格");

    try{
      joinPoint.proceed();
    }catch (Throwable throwable){
      throwable.printStackTrace();
    }

    System.out.println("交钥匙");
  }

}
