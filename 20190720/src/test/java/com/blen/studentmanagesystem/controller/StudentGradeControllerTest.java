package com.blen.studentmanagesystem.controller;

    import com.blen.studentmanagesystem.StudentManageSystemApplicationTests;
import com.blen.studentmanagesystem.controller.req.StudentGradeCreateParam;
import com.blen.studentmanagesystem.controller.req.StudentGradeRemoveParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertTrue;

@Slf4j
public class StudentGradeControllerTest extends StudentManageSystemApplicationTests {

  private final static String URL = "/grade";
  private final static int CODE = 200;

  public StudentGradeCreateParam creatParam(Long code, String name, int year, Double math, Double english, Double chinese){

    return StudentGradeCreateParam.builder()
        .code(code)
        .name(name)
        .year(year)
        .math(math)
        .english(english)
        .chinese(chinese)
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
    StudentGradeCreateParam resultParam = creatParam(100L,"han",2018,100D,100D,100D);
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    assertTrue( responseEntity.getStatusCodeValue() == CODE);

    Long id = Long.valueOf(responseEntity.getBody());

    assertTrue(id > 0);
    resultParam = creatParam(null,"han",2018,100D,100D,100D);
    responseEntity= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    System.out.println(responseEntity.getBody());
    assertTrue(responseEntity.getBody().contains("NotNull.code"));
  }

  @Test
  public void delete(){

    StudentGradeCreateParam resultParamAdd = creatParam(200L,"han",2018,100D,100D,100D);
    ResponseEntity<String> responseEntityAdd= restTemplate.postForEntity(URL + "/add", resultParamAdd, String.class);
    assertTrue( responseEntityAdd.getStatusCodeValue() == CODE);

    StudentGradeRemoveParam removeParam = StudentGradeRemoveParam.builder()
        .code(200L)
        .year(2018)
        .build();
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/delete",removeParam, String.class);

    System.out.println(responseEntity.getBody());
    assertTrue( responseEntity.getStatusCodeValue() == CODE);
  }

  @Test
  public void update(){
    StudentGradeCreateParam resultParamAdd = creatParam(300L,"han",2018,100D,100D,100D);
    ResponseEntity<String> responseEntityAdd= restTemplate.postForEntity(URL + "/add", resultParamAdd, String.class);
    assertTrue( responseEntityAdd.getStatusCodeValue() == CODE);

    StudentGradeCreateParam resultParam = creatParam(300L,"han",2018,90D,90D,90D);
    ResponseEntity<String> responseEntity= restTemplate.postForEntity(URL + "/update", resultParam, String.class);
    assertTrue( responseEntity.getStatusCodeValue() == CODE);

    Long id = Long.valueOf(responseEntity.getBody());

    assertTrue(id > 0);
  }

  @Test
  public void get(){
    StudentGradeCreateParam resultParam = creatParam(400L,"han",2018,100D,100D,100D);
    ResponseEntity<String> responseEntityAdd= restTemplate.postForEntity(URL + "/add", resultParam, String.class);
    assertTrue( responseEntityAdd.getStatusCodeValue() == CODE);

    ResponseEntity<String> responseEntity= restTemplate.getForEntity(URL + "/get/?code=400&year=2018", String.class);

    System.out.println(responseEntity.getBody());
    assertTrue( responseEntity.getStatusCodeValue() == CODE);
  }

}
