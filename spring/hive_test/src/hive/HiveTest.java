package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			conn = DriverManager.getConnection("jdbc:hive2://70.12.114.146:10000/default", "root", "1234");
			stmt = conn.createStatement();
			stmt.execute("LOAD DATA LOCAL INPATH '/root/sensorLog/sensor.csv' OVERWRITE INTO TABLE HEXAINFO PARTITION (occurrenceYear='2030')");
//			stmt.executeQuery("");
//			stmt.executeQuery("");
	
//			while (rs.next()) {
//				System.out.println(rs.getString(1)+ rs.getString(2) +rs.getString(3) +rs.getString(4) + rs.getString(5)+ rs.getString(6)+ rs.getString(7)+ rs.getString(8)+rs.getString(9));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Success");
	}
}