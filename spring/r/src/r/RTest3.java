package r;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest3 {

	public static void main(String[] args) {
		//��������
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
			rconn.eval("source('C:/Users/student/Documents/TIL/R/day09/r1.R',encoding='UTF-8')");
			RList list = 
					rconn.eval("r3()").asList();
			System.out.println(list.size());
			
			String time[] = 
					list.at("time").asStrings(); //�÷���Ī�� ���ؼ� �����´�.
			
			double line2[] = 
					list.at("line2").asDoubles();
			
			double line3[] = 
					list.at("line3").asDoubles();
			
			double line4[] = 
					list.at("line4").asDoubles();
			
			JSONArray ja = new JSONArray();  // []ū�ٱ���
			JSONObject jo = new JSONObject(); // {}
			
			JSONArray ja_time = new JSONArray(); // �ȿ� ���			
			for(String d:time) {
				ja_time.add(d);
			}			
			jo.put("time", ja_time);  // {time:["6��", ... "10��"]} ��Ī��Ű�°�, jo�� ����ִ°�
			
			
			JSONArray ja_line2 = new JSONArray();
			for (double d:line2) {
				ja_line2.add(d);
			}
			jo.put("line2", ja_line2);
			
			JSONArray ja_line3 = new JSONArray();
			for (double d:line3) {
				ja_line3.add(d);
			}
			jo.put("line3", ja_line3);
			
			JSONArray ja_line4 = new JSONArray();
			for (double d:line4) {
				ja_line4.add(d);
			}
			jo.put("line4", ja_line4);  // "line4" JSON�ȿ� �̸��� ���Ѱ�

			ja.add(jo);    // []ū�ٱ��ϸ� �Ѱ��� �ִ´�.
			
			System.out.println(ja.toJSONString());
			
			System.out.println();
			System.out.println(time.length);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
