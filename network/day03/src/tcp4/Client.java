package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import tcp4.Server.Receiver;
import tcp4.Server.Sender;

public class Client {
	String ip;
	int port;
	Socket socket;
	boolean flag = true;
	InputStream in = null;
	DataInputStream din = null;
	OutputStream out = null;
	DataOutputStream dout = null;

	public Client() {
		ip = "70.12.114.145";
		port = 9999;
		flag = true;
	}

	public void startClient() throws UnknownHostException, IOException {
		socket = new Socket(ip, port);
		in = socket.getInputStream();
		din = new DataInputStream(in);
		out = socket.getOutputStream();
		dout = new DataOutputStream(out);

		Scanner scanner = new Scanner(System.in);
		Receiver receiver = new Receiver();
		receiver.start();
		while (flag) {
			System.out.println("Input Client.. ");
			String str = scanner.nextLine();

			if (str.equals("q")) {
				scanner.close();
				break;
			}
			//
			Thread t = new Thread(new Sender(str));
			t.start();
		}
		System.out.println("Stop Client");
	}

	class Receiver extends Thread { // 클라이언트에서 받는 역할만 함
		@Override

		public void run() {
			System.out.println("Client Receiver");
			while (true) {
				try {
					System.out.println("서버로부터 아래의 메시지가 왔습니다.");
					System.out.println(din.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Sender implements Runnable {
		String msg;

		public Sender(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			try {
				dout.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Client ::: ");
		Client client = new Client();
		try {
			client.startClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
