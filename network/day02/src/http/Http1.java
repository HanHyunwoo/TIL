package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Http1 {

	public static void main(String[] args) {
//		InetAddress ia = null;
//		ia = InetAddress.getByName("localhost");
//		System.out.println(ia.getHostAddress());
//		System.out.println(ia.getHostName());
		
		URL url = null;
		String address = "http://www.e-ncs.kr/#/login";
		
		try {
			url = new URL(address);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����ó���Ҷ� inputStream, ���� ó���Ҷ� InputStreamReader �ȱ׷��� �ѱ� ����
		InputStreamReader in = null;
		BufferedReader br = null;  //Ư�������� �����ŭ ���� , �ַ� line������ ����
		String str = null; //�о���ΰ� ����, ��Ʈ���� �ѹ� ������ ������ �� ����. str = "aa" <-�̷��� ������ �մ°� ������ ���� ��°���
		StringBuffer sb = new StringBuffer();//��Ʈ�����۴� �������� �����ϰų� ���� ���뿡 ������ �߰��� �� ����. 
		
		try {
			in = new InputStreamReader(url.openStream());
			br = new BufferedReader(in);
			while(true) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				sb.append(str + "\n");
			}
				
		} catch (IOException e) { //IOException ������ �׾��ų�, ��Ʈ��ũ�� �������� �� �߻�
			e.printStackTrace();
		} finally {
			try {
				br.close();//br.close();�ϸ� in���� close�ȴ�.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		
		System.out.println(sb.toString());

		

	}

}
