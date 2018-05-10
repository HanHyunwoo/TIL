package tcp7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends Thread {
	// 1. 소켓을 만드는 역할
	// 2. Receiver
	// 3. Sender

	String address = "70.12.114.143";
	Socket socket;
	Scanner scanner;
	boolean cflag = true;
	boolean flag = true;

	public Client() {
	}

	@Override
	public void run() {
		// 재접속을 위한 while
		while (cflag) {
			try {
				socket = new Socket(address, 7575);
				System.out.println("Connected Server ..");
				cflag = false;
				break;
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Connected Retry ..");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		// After Connected..
		try {
			new Receiver(socket).start(); // 받는 쓰레드
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMsg(String msg) { // 클라이언트가 메시지를 받으면 전송할거임
		try {
			Sender sender = new Sender(socket);
			sender.setSendMsg(msg);
			new Thread(sender).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Sender implements Runnable {
		Socket socket;
		OutputStream out;
		DataOutputStream outw;
		String sendMsg;

		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			out = socket.getOutputStream();
			outw = new DataOutputStream(out);
		}

		public void setSendMsg(String sendMsg) {
			this.sendMsg = sendMsg;
		}

		@Override
		public void run() {
			try {
				if (outw != null) {
					// 계속 보내는 역할을 한다.
					outw.writeUTF(sendMsg);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Receiver extends Thread {
		Socket socket;
		InputStream in;
		DataInputStream inr;

		public Receiver(Socket socket) throws IOException {
			// Input의 역할을 한다.
			this.socket = socket;
			in = socket.getInputStream();
			inr = new DataInputStream(in);
		}

		@Override
		public void run() {
			// 계속 스레드가 실행하며 문자열을 받는다.
			try {
				while (flag == true && inr != null) {

					String str = inr.readUTF();
					System.out.println(str);
					if (str.trim().equals("q")) {
						inr.close();
						break;
					}
				}
			} catch (Exception e) {

			} finally {
				if (inr != null) { // while이 종료되면 finally를 통해서 inputStream을 종료
					try {
						inr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	public void stopClient() {
		try {
			Thread.sleep(1000);
			flag = false;
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}