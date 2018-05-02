package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONArray;

public class HiveTest {

   public static void main(String[] args) throws Exception {
      Class.forName("org.apache.hive.jdbc.HiveDriver");
      Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.111.100:10000/" + "default", "root", "111111");
      Statement stmt = conn.createStatement();

	//ResultSet rs = stmt.executeQuery("select * from airline LIMIT 10");
	//ResultSet rs = stmt.executeQuery("select * from car_accident LIMIT 10");
      
      ResultSet rs = stmt.executeQuery("SELECT Year, Month, COUNT(*) " + "FROM airline_delay "
            + "WHERE delayYear=2006 " + "AND Month IN (1,2,3,4) " + "AND ArrDelay > 0 " + "GROUP BY Year, Month");
      JSONArray ja = new JSONArray(); // import�� ���̺귯�� ����� [] ������

      while (rs.next()) {
         JSONArray data = new JSONArray(); // []�ȿ� []�� ����
         
         data.add(rs.getInt(2) + "��");
         data.add(rs.getInt(3));
         // ["1��", 20000]
         ja.add(data);
      }
      // [[],[],[]]
      System.out.println(ja.toJSONString());
      conn.close();
      System.out.println("Success....");
   }

}