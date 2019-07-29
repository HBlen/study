package com.blen.studentmanagesystem.controller;

import com.blen.studentmanagesystem.StudentManageSystemApplicationTests;
import com.blen.studentmanagesystem.controller.req.TeacherInfoCreateParam;
import com.blen.studentmanagesystem.controller.req.TeacherInfoRemoveParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertTrue;

public class TeacherInfoControllerTest extends StudentManageSystemApplicationTests {

  private final static String URL = "/teacherinfo";
  private final static int CODE = 200;

  @Autowired
  private TestRestTemplate restTemplate;

  private TeacherInfoCreateParam saveTeacherParam( Long code, String name, String sex, int age, String classname){
    return TeacherInfoCreateParam.builder()
        .code(code)
        .name(name)
        .sex(sex)
        .age(age)
        .classname(classname)
        .build();
  }

  /**
   * @testCase 1、添加正常数据
   * @testCase 2、错误参数验证
   */
  @Test
  public void creat(){
    TeacherInfoCreateParam resultParam = saveTeacherParam(100L,"zhang","male",20,"sanban");
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    assertTrue( responseEntity.getStatusCodeValue() == CODE);

    Long id = Long.valueOf(responseEntity.getBody());

    assertTrue(id > 0);
    resultParam = saveTeacherParam(null,"zhang","male",20,"sanban");
    responseEntity= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    System.out.println(responseEntity.getBody());
    assertTrue(responseEntity.getBody().contains("NotNull.code"));
  }

  @Test
  public void delete(){

    TeacherInfoRemoveParam removeParam =  TeacherInfoRemoveParam.builder()
        .code(100L)
        .name("zhang")
        .build();
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/delete", removeParam, String.class);

    System.out.println(responseEntity.getBody());
    assertTrue( responseEntity.getStatusCodeValue() == CODE);
  }

  @Test
  public void update(){

    TeacherInfoCreateParam resultParamAdd = saveTeacherParam(300L,"test3","male",20,"sanban");
    ResponseEntity<String> responseEntityAdd = restTemplate.postForEntity(URL + "/add", resultParamAdd, String.class);
    assertTrue( responseEntityAdd.getStatusCodeValue() == CODE);

    TeacherInfoCreateParam resultParamUpdate = saveTeacherParam(300L,"test3","female",20,"sanshiban");
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/update", resultParamUpdate, String.class);
    assertTrue( responseEntity.getStatusCodeValue() == CODE);

    Long id = Long.valueOf(responseEntity.getBody());

    assertTrue(id > 0);
  }

  @Test
  public void get(){
    TeacherInfoCreateParam resultParamAdd = saveTeacherParam(400L,"test4","male",20,"sanban");
    ResponseEntity<String> responseEntityAdd = restTemplate.postForEntity(URL + "/add", resultParamAdd, String.class);
    assertTrue( responseEntityAdd.getStatusCodeValue() == CODE);

    ResponseEntity<String> responseEntity= restTemplate.getForEntity(URL + "/get/?code=400&name=test4", String.class);

    System.out.println(responseEntity.getBody());
    assertTrue( responseEntity.getStatusCodeValue() == CODE);
  }

}
