package r;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest {

	public static void main(String[] args) {
		//로컬접속
		RConnection rconn = null;
		try {
			//rconn = new RConnection("70.12.114.144");
			rconn = new RConnection();
			System.out.println("OK!!");
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println();
		
		
		try {
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/Users/student/Documents/TIL/R/day09/r1.R',encoding='UTF-8')");
			//rconn.eval("source('C:/rproject/day09/r1.R',encoding='UTF-8')");
			
			int a = 100;
			int b= 87;
			
			double data =rconn.eval("r1(" + a+ "," +b +")").asDouble();
			//rconn.eval("r1()").asDouble(); //eval은 해당프로그램에서 실행한다는 의미			
			System.out.println(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
