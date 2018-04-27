package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Server_teacher 에서 Sender클래스만 분리한거임
class Sender implements Runnable {
	Socket socket;
	OutputStream out;
	OutputStreamWriter outw; // 한글 보낼때 사용

	public Sender() {
	}

	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		out = socket.getOutputStream();
		//tcp1에서 사용한 예제와 다른 점은 socket과 OutputStream 객체들을 공유하느냐 아니냐의 차이
	    //만약에 공유한다면 OutputStream을 수행하는 도중에 socket에 새로운 객체가 담기게 되면
	    //문제가 생길 수 있음
		outw = new OutputStreamWriter(out);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			outw.write("안녕");
		} catch (Exception e) {
			e.printStackTrace();// 쓰레드 안에서는 밖으로 던질 수가 없다. 안에서 처리해야 됨

		} finally {
			if (outw != null) {
				try {
					outw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class Server_teacher2 {
	int port;
	ServerSocket serverSocket;
	Boolean flag = true;

	public Server_teacher2() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); // 예외처리 try/catch로하면 콘솔에만 나올뿐 main에선 알수가 없다. 그래서 던져줘라(throws)
	}

	public Server_teacher2(Socket socket) {

	}

	// Accept Client Socket And Sender Thread Create and Start
	public void startServer() throws IOException {

		while (flag) {// 함수안에 변수는 스택에 만들어진다,
			Socket socket = null;
			System.out.println("Ready Server....");
			socket = serverSocket.accept();
			Sender sender = new Sender(socket);
			new Thread(sender).start();
			System.out.println("Accepted Client...." + socket.getInetAddress());

		}

	}


	public static void main(String[] args) {
		Server_teacher2 server = null;
		try {
			server = new Server_teacher2();
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
