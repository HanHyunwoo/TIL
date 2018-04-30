package r;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest2 {

	public static void main(String[] args) {
		//��������
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
			// [] ���̽��� �ǹ�, {}�� ��ü(������Ʈ)�� ����
			// [{name:"data", datas:[1,2,3,4,5,...10]}]  
			// :name�̶�� ���� ����� "data"�� �ְٴ�, datas��� ���� ����� [1,2,3,4,5...10]�� �ְڴ�
			
			JSONArray ja = new JSONArray();  // [] 
			JSONObject jo = new JSONObject();
			jo.put("name", "data");
			
			JSONArray ja_sub = new JSONArray(); //���̽� ��̸����	 [1,2,3,4,5,...10]		
			for(double d:data) {
				ja_sub.add(d);
			}
			
			jo.put("datas",ja_sub);
			
			ja.add(jo);  //[]
			
			//rconn.eval("r1()").asDouble(); //eval�� �ش����α׷����� �����Ѵٴ� �ǹ�			
			System.out.println(ja.toJSONString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
