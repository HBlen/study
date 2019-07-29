package com.blen.studentmanagesystem.controller;

import com.blen.studentmanagesystem.StudentManageSystemApplicationTests;
import com.blen.studentmanagesystem.controller.req.StudentInfoCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentInfoRemoveParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertTrue;

@Slf4j
public class StudentInfoControllerTest  extends StudentManageSystemApplicationTests {

  private final static String URL = "/studentinfo";
  private final static int CODE = 200;

  public StudentInfoCreateParam creatParam(Long code, String name, String sex, int age, String classname){

    return StudentInfoCreateParam.builder()
        .code(code)
        .name(name)
        .sex(sex)
        .age(age)
        .classname(classname)
        .build();
  }


  @Autowired
  private TestRestTemplate restTemplate;

  /**
   * @testCase 1、添加正常数据
   * @testCase 2、错误参数验证
   */
  @Test
  public void creat(){
    StudentInfoCreateParam resultParam = creatParam(1000L,"zha","male",20,"sanban");
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    assertTrue( responseEntity.getStatusCodeValue() == CODE);

    Long id = Long.valueOf(responseEntity.getBody());

    assertTrue(id > 0);
    resultParam = creatParam(null,"zhang","male",20,"sanban");
    responseEntity= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    System.out.println(responseEntity.getBody());
    assertTrue(responseEntity.getBody().contains("NotNull.code"));
  }

  @Test
  public void delete(){

    StudentInfoRemoveParam removeParam = StudentInfoRemoveParam.builder()
    .code(512L)
        .name("zhang")
        .build();
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/delete",removeParam, String.class);

    System.out.println(responseEntity.getBody());
    assertTrue( responseEntity.getStatusCodeValue() == CODE);
  }

  @Test
  public void update(){
    StudentInfoCreateParam resultParam = creatParam(100L,"zha","male",20,"sanban");
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/update", resultParam, String.class);
    assertTrue( responseEntity.getStatusCodeValue() == CODE);

    Long id = Long.valueOf(responseEntity.getBody());

    assertTrue(id > 0);
  }

  @Test
  public void get(){
    ResponseEntity<String> responseEntity= restTemplate.getForEntity(URL + "/get/?code=5&name=zha", String.class);

    System.out.println(responseEntity.getBody());
    assertTrue( responseEntity.getStatusCodeValue() == CODE);
  }

}
