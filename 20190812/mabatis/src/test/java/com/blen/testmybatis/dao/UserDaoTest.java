package com.blen.testmybatis.dao;

import java.io.IOException;

import com.blen.testmybatis.domain.User;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {

  @Test
  public void find_user_by_id(){
    SqlSession sqlSession = getSessionFactory().openSession();
    UserDao userMapper = sqlSession.getMapper(UserDao.class);
    User user = userMapper.findUserById(2);
    Assert.assertNotNull("没有找到数据", user);
  }

  // Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
  private static SqlSessionFactory  getSessionFactory(){

    SqlSessionFactory sessionFactory =null;
    String resource = "mybatis-config.xml";
    try{
      sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
    }catch (IOException e){
      e.printStackTrace();
    }
    return sessionFactory;
  }

}
