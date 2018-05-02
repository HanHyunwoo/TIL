package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONArray;

/**
 * 
 * 하이브가 Service나 Daemon 형태로 떠 있어야 함 
 *
 */
public class HiveTest2 {
   public static void main(String[] args) throws Exception {
      Class.forName("org.apache.hive.jdbc.HiveDriver");
      Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.111.102:10000/default", "root", "111111");
      Statement stmt = conn.createStatement();
//      ResultSet rs = stmt.executeQuery("select * from airline_delay limit 10");
      //2006년 월 별 지연출발, 지연도착 평균을 구하시오
      ResultSet rs = stmt.executeQuery("select * from airline_delay limit 3");
//      ResultSet rs = stmt.executeQuery("SELECT Year,Month,COUNT(*) "
//        + "FROM airline_delay "
//        + "where delayYear=2006 "
//        + "AND Month IN (1,2,3,4) "
//        + "AND ArrDelay >0 "
//        + "GROUP BY Year,Month ");
      JSONArray ja = new JSONArray();
      // [] 이게 하나 만들어짐
      
      while (rs.next()) {
         JSONArray data = new JSONArray();
         // [] 이게 하나 만들어짐
         data.add(rs.getInt(2)+"월");
         data.add(rs.getInt(3));
         ja.add(data);   // 배열 안의 배열 모양이 된다. chart1의 data와 일치
      }
      
      System.out.println(ja.toJSONString());
      
      
      //시군구 별, 발생건수 합
//      ResultSet rs = stmt.executeQuery("select "
//            + "B.SiGunGuName, sum(A.Cnt)"
//            + "from RealInfo_Cold_SiGunGu A "
//            + "join SiGunGu_LocalCode B on (A.SiGunGuLocalCode = B.SiGunGuLocalCode) "
//            + "join SiDo_LocalCode C on (B.HighSiDoLocalCode  = C.SiDoLocalCode) "
//            + "group by B.SiGunGuName ");
      
      /*while (rs.next()) {
         System.out.println(
               + rs.getInt(2) + " "
               + rs.getInt(3)
               );
      }*/
      conn.close();
      System.out.println("Success....");   
   }
}