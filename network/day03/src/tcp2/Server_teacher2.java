package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Server_teacher ���� SenderŬ������ �и��Ѱ���
class Sender implements Runnable {
	Socket socket;
	OutputStream out;
	OutputStreamWriter outw; // �ѱ� ������ ���

	public Sender() {
	}

	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		out = socket.getOutputStream();
		//tcp1���� ����� ������ �ٸ� ���� socket�� OutputStream ��ü���� �����ϴ��� �ƴϳ��� ����
	    //���࿡ �����Ѵٸ� OutputStream�� �����ϴ� ���߿� socket�� ���ο� ��ü�� ���� �Ǹ�
	    //������ ���� �� ����
		outw = new OutputStreamWriter(out);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			outw.write("�ȳ�");
		} catch (Exception e) {
			e.printStackTrace();// ������ �ȿ����� ������ ���� ���� ����. �ȿ��� ó���ؾ� ��

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
		serverSocket = new ServerSocket(port); // ����ó�� try/catch���ϸ� �ֿܼ��� ���û� main���� �˼��� ����. �׷��� �������(throws)
	}

	public Server_teacher2(Socket socket) {

	}

	// Accept Client Socket And Sender Thread Create and Start
	public void startServer() throws IOException {

		while (flag) {// �Լ��ȿ� ������ ���ÿ� ���������,
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
