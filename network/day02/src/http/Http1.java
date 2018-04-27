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
		
		//파일처리할땐 inputStream, 문자 처리할땐 InputStreamReader 안그러면 한글 깨짐
		InputStreamReader in = null;
		BufferedReader br = null;  //특정버퍼의 사이즈만큼 읽음 , 주로 line단위로 읽음
		String str = null; //읽어들인걸 받음, 스트링은 한번 받으면 변경할 수 없다. str = "aa" <-이런건 기존에 잇는걸 버리고 새로 담는거임
		StringBuffer sb = new StringBuffer();//스트링버퍼는 받은것을 변경하거나 기존 내용에 내용을 추가할 수 있음. 
		
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
				
		} catch (IOException e) { //IOException 서버가 죽었거나, 네트워크가 끊어졌을 떄 발생
			e.printStackTrace();
		} finally {
			try {
				br.close();//br.close();하면 in까지 close된다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		
		System.out.println(sb.toString());

		

	}

}
