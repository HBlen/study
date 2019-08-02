import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class Main {

  public static void main(String[] args) {
      //crud.add("huo","www.huo.com",1,"CHN");
     // crud.delete(6);
//      crud.modify(2,"TMALL","www.t-mall.com",3,"CN");
  List<WebSites> sitesList = crud.findCourseList();
  for (WebSites s:sitesList) {
      System.out.println(s.toString());

  }
  }


}
