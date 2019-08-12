package com.blen.testmybatis.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class User {
  private int id;
  private String name;
  private String password;
  private int age;
  private int deleteFlag;

}
