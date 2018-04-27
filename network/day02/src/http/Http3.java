package http;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Http3 {

	public static void main(String[] args) throws Exception{
		URL url = new URL("http://127.0.0.1/on.mp3");
		
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("on.mp3");  //C:\Users\student\Documents\TIL\network\day02 에 받아짐\
		//FileOutputStream out = new FileOutputStream("c://on.mp3");  //이렇게 경로지정도 가능
		
		int i = 0;
		while(true) {
			System.out.println(i);
			i = in.read();
			if (i == -1) {  // -1이라는게 파일의 끝임
				break;
			}
			out.write(i);
		}
		in.close();
		out.close();

	}

}
