import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class DbUtil {

  public static Connection getConnection(){
    Connection conn = null;
    try {
      //初始化驱动类com.mysql.jdbc.Driver
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCTest?characterEncoding=UTF-8","root", "newpass");
      //该类就在 mysql-connector-java-5.0.8-bin.jar中,如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  /**
   * 封装三个关闭方法
   * @param pstmt
   */
  public static void close(PreparedStatement pstmt){
    if(pstmt != null){						//避免出现空指针异常
      try{
        pstmt.close();
      }catch(SQLException e){
        e.printStackTrace();
      }

    }
  }

  public static void close(Connection conn){
    if(conn != null){
      try {
        conn.close();
      } catch (SQLException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
  }

  public static void close(ResultSet rs){
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
  }

}
