package r;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest2 {

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
			
			double data[] =
					rconn.eval("r2()").asDoubles();
			// [] 제이슨을 의미, {}는 객체(오브젝트)를 뜻함
			// [{name:"data", datas:[1,2,3,4,5,...10]}]  
			// :name이라는 방을 만들고 "data"를 넣겟다, datas라는 방을 만들고 [1,2,3,4,5...10]을 넣겠다
			
			JSONArray ja = new JSONArray();  // [] 
			JSONObject jo = new JSONObject();
			jo.put("name", "data");
			
			JSONArray ja_sub = new JSONArray(); //제이슨 어레이만든거	 [1,2,3,4,5,...10]		
			for(double d:data) {
				ja_sub.add(d);
			}
			
			jo.put("datas",ja_sub);
			
			ja.add(jo);  //[]
			
			//rconn.eval("r1()").asDouble(); //eval은 해당프로그램에서 실행한다는 의미			
			System.out.println(ja.toJSONString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
