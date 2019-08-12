package com.blen.testmybatis.dao;

import java.util.List;

import com.blen.testmybatis.domain.User;

public interface UserDao {
  public void insert(User user);
  public User findUserById(int userId);
  public List<User> findAllUsers();

}
