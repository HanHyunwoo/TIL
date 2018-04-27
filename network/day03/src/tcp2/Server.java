package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	OutputStream out;
	OutputStreamWriter outw; // 한글 보낼때 사용
	Boolean flag = true;

	public Server() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); // 예외처리 try/catch로하면 콘솔에만 나올뿐 main에선 알수가 없다. 그래서 던져줘라(throws)
	}

	// Accept Client Socket And Sender Thread Create and Start
	public void startServer() {
		Sender sender = new Sender();
		Thread t1 = new Thread(sender);
		t1.start();
	}

	class Sender implements Runnable {

		public Sender() {}
		@Override
		public void run() {
			
			while (flag) {
				try {

//  				이부분을 쓰레드로 분리처리해야하는데 나는 그냥 쓰레드만 만들었지 분리는 못했음.
//					System.out.println("Ready Server....");
//					socket = serverSocket.accept(); // 연결될때까지 기다린다.
//					System.out.println("Accepted Client...." + socket.getInetAddress());
//					out = socket.getOutputStream();
//					outw = new OutputStreamWriter(out);

					
					System.out.println("Ready Server....");
					socket = serverSocket.accept(); // 연결될때까지 기다린다.
					System.out.println("Accepted Client...." + socket.getInetAddress());
					out = socket.getOutputStream();
					outw = new OutputStreamWriter(out);

					// 다중접속 서버에 적합하지 않다.
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outw.write("안녕");

				} catch (IOException e) {
					try {
						throw e;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // 던져줘라 , 이렇게 하는 이유는 파이널리를 위해서
				} finally {
					if (outw != null) {
						try {
							outw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}

		}

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
