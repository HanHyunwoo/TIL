package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	String ip;
	int port;
	Socket socket;
	InputStream in;
	InputStreamReader inr;
	BufferedReader br;

	public Client() {
	}

	public Client(String ip, int port) throws UnknownHostException, IOException {
		this.ip = ip;
		this.port = port;
		connect();
		startClient();
	}

	public void connect() {
		boolean flag2 = true;
		while (flag2) {
			try {
				socket = new Socket(ip, port);
				if (socket != null && socket.isConnected()) {
					break;
				}
			} catch (IOException e) {
				System.out.println("Re-Try");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {}
			}
		}
	}

	public void startClient() throws UnknownHostException, IOException {
		try {
			// socket = new Socket(ip,port);
			System.out.println("Connected");
			in = socket.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			String str = br.readLine();
			System.out.println(str);
		} catch (UnknownHostException e) { // ip�ȸ´� ����ó��
			throw e;
		} catch (IOException e) { // ip�� �¾Ҵµ�, ������ �׾��ų� �������� �ʴ� ����ó����
			throw e;
		} finally {
			br.close();
			socket.close();
		}
	}

	public static void main(String[] args) {
		Client client = null;

		try {
			client = new Client("70.12.114.143", 7777);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// client.startClient();

	}

}
