package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Http2 {

	public static void main(String[] args) throws Exception{
		String name = "����";
		//���� ��Ʈ���� �ѱ۷� ������, http�� ������ ������ ������, �׷��� �ѱۺκи� ���� encode
		name = URLEncoder.encode(name,"UTF-8");
		String sur1 = "http://127.0.0.1/login?id=qq&pwd=11&name=" + name;
		
		URL url = new URL(sur1);  
		
		
		//URL url = new URL("http://127.0.0.1/login");
		URLConnection con = url.openConnection();
		con.setConnectTimeout(5000);  //5�ʵ��� ������ ������
		
		//con.setRequestProperty("id", "qq");
		//con.setRequestProperty("pwd", "11");
		
		InputStream in = con.getInputStream();
		InputStreamReader ir = new InputStreamReader(in,"utf-8");
		BufferedReader br = new BufferedReader(ir);
		
		String str = br.readLine();
		System.out.println(str);
		br.close();

	}

}
