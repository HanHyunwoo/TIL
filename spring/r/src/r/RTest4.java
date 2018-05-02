package r;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest4 {

	public static void main(String[] args) {
		//로컬접속
		RConnection rconn = null;
		try {
			rconn = new RConnection();
			System.out.println("OK!!");
		} catch (RserveException e) {
			System.out.println("R Connection Error");
		}
		System.out.println();
		
		
		try {
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/Users/student/Documents/TIL/R/day08/r10.R',encoding='UTF-8')");
			RList list = 
					rconn.eval("food()").asList();
			System.out.println(list.size());
			
			int good[] = 
					list.at("good").asIntegers(); //컬럼명칭을 통해서 가져온다.
			
			int bad[] = 
					list.at("bad").asIntegers();
			
			int snow[] = 
					list.at("snow").asIntegers();
			
	
			for(int i=0; i<good.length; i++) {
				
				System.out.println(good[i]+" "+bad[i]+" "+snow[i]);
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
