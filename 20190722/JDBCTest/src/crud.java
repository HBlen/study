import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class crud {


  public static void add(String name, String url, int alexa, String country) {
    String sql = "insert into websites(t_name,t_url,t_alexa,t_country) values(?,?,?,?)";
    Connection conn = null; // 和数据库连接
    PreparedStatement pstmt = null; // 创建statement
    try {
      conn = DbUtil.getConnection();
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      // 占位符赋值
      pstmt.setString(1, name);
      pstmt.setString(2, url);
      pstmt.setInt(3, alexa);
      pstmt.setString(4, country);

      pstmt.executeUpdate(); // 执行
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbUtil.close(pstmt);
      DbUtil.close(conn); // 必须关闭
    }
  }

  public static void delete(int id) {
    String sql = "delete from websites where t_id = ?";
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DbUtil.getConnection();
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      {
        DbUtil.close(pstmt);
        DbUtil.close(conn);
      }
    }
  }

  public static void modify(int id, String name, String url, int alexa, String country) {
    String sql = "update websites set t_name=?,t_url=?,t_alexa =?,t_country=? where t_id=?";
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      conn = DbUtil.getConnection();
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, url);
      pstmt.setInt(3, alexa);
      pstmt.setString(4, country);
      pstmt.setInt(5,id);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbUtil.close(pstmt);
      DbUtil.close(conn);
    }
  }

  /**
   * 查询课程
   * @return
   */
  public static List<WebSites> findCourseList(){
    String sql = "select * from websites order by t_id";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //创建一个集合对象用来存放查询到的数据
    List<WebSites> sitesList = new ArrayList<>();
    try {
      conn = DbUtil.getConnection();
      pstmt = (PreparedStatement) conn.prepareStatement(sql);
      rs = (ResultSet) pstmt.executeQuery();
      while (rs.next()){
        String name = rs.getString("t_name");
        String url = rs.getString("t_url");
        int alexa = rs.getInt("t_alexa");
        String country = rs.getString("t_country");

        //每个记录对应一个对象
        WebSites site = new WebSites();
        site.setName(name);
        site.setUrl(url);
        site.setAlexa(alexa);
        site.setCountry(country);

        //将对象放到集合中
        sitesList.add(site);
      }
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    }finally{
      DbUtil.close(pstmt);
      DbUtil.close(conn);		//必须关闭
    }
    return sitesList;
  }

}
