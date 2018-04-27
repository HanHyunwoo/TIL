package tcp1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;  //포트와 연결(bind)되어 연결요청을 기다림
	Socket socket;	// 두 프로세스간의 통신을 담당
	OutputStream out;	//
	OutputStreamWriter outw; // 한글 보낼때 사용
	Boolean flag = true;

	public Server() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); // 예외처리 try/catch로하면 콘솔에만 나올뿐 main에선 알수가 없다. 그래서 던져줘라(throws)
	}

	public void startServer() throws IOException {
		System.out.println("Start Server....");

		while (flag) {
			try {
				System.out.println("Ready Server....");
				socket = serverSocket.accept(); // 연결될때까지 기다린다.
				System.out.println("Accepted Client...." + socket.getInetAddress());
				out = socket.getOutputStream();
				outw = new OutputStreamWriter(out);
				
				//다중접속 서버에 적합하지 않다. 
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				outw.write("안녕");

			} catch (IOException e) {
				throw e; // 던져줘라 , 이렇게 하는 이유는 파이널리를 위해서
			} finally {
				if (outw != null) {
					outw.close();
				}
				
				if (socket != null) {
					socket.close();
				}
		
			}
		}
		System.out.println("End Server....");

	}

	public static void main(String[] args) {
		Server server = null;
		try {
			server = new Server();
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
