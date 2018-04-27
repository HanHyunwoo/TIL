package tcp1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;  //��Ʈ�� ����(bind)�Ǿ� �����û�� ��ٸ�
	Socket socket;	// �� ���μ������� ����� ���
	OutputStream out;	//
	OutputStreamWriter outw; // �ѱ� ������ ���
	Boolean flag = true;

	public Server() throws IOException {
		port = 7777;
		serverSocket = new ServerSocket(port); // ����ó�� try/catch���ϸ� �ֿܼ��� ���û� main���� �˼��� ����. �׷��� �������(throws)
	}

	public void startServer() throws IOException {
		System.out.println("Start Server....");

		while (flag) {
			try {
				System.out.println("Ready Server....");
				socket = serverSocket.accept(); // ����ɶ����� ��ٸ���.
				System.out.println("Accepted Client...." + socket.getInetAddress());
				out = socket.getOutputStream();
				outw = new OutputStreamWriter(out);
				
				//�������� ������ �������� �ʴ�. 
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				outw.write("�ȳ�");

			} catch (IOException e) {
				throw e; // ������� , �̷��� �ϴ� ������ ���̳θ��� ���ؼ�
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
