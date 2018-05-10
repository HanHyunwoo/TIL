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
	// 1. ������ ����� ����
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
		// �������� ���� while
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
			new Receiver(socket).start(); // �޴� ������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMsg(String msg) { // Ŭ���̾�Ʈ�� �޽����� ������ �����Ұ���
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
					// ��� ������ ������ �Ѵ�.
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
			// Input�� ������ �Ѵ�.
			this.socket = socket;
			in = socket.getInputStream();
			inr = new DataInputStream(in);
		}

		@Override
		public void run() {
			// ��� �����尡 �����ϸ� ���ڿ��� �޴´�.
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
				if (inr != null) { // while�� ����Ǹ� finally�� ���ؼ� inputStream�� ����
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