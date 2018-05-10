package myPractice;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	boolean flag;
	InputStream in;
	DataInputStream din;
	// OutputStream out;
	// DataOutputStream dout;

	public Server() throws IOException {
		port = 7575;
		serverSocket = new ServerSocket(port);
		System.out.println("startServer1111");
	}

	public void startServer() throws IOException {
		while (true) {
			socket = serverSocket.accept();
			in = socket.getInputStream();
			din = new DataInputStream(in);
			System.out.println("startServer 시작");
			new Receiver().start(); //바로 실행 , 변수에 안했으므로 접근할 방법이 없다
		}

	}

	class Receiver extends Thread {
		@Override
		public void run() {
			
			while (true) {
				String str = "";
				try {
					str = din.readUTF();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println(str);
			}
			
		}
	}

	public static void main(String args[]) {
		Server server = null ;
		try {
			server = new Server();
			server.startServer();
			
			System.out.println("startServer2");
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}
