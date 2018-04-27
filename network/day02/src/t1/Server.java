package t1;
import java.util.Scanner;

public class Server {	
	boolean flag = true;
	
	public void startServer(){
		Scanner client = new Scanner(System.in);
		
		while(flag) {
			System.out.println("Server Ready");
			String msg = client.nextLine();  //nextLine������ ����, ��ٸ��°���~
			System.out.println(msg);
			
			// Receiver Thread
			Receiver receiver = new Receiver(msg);
			receiver.start();
		}
		
		}

	public static void main(String[] args) {
		System.out.println("Server Start");
		new Server().startServer();
		System.out.println("Server Stop");	
	}

	
	// ��û�� �޾Ƽ� ó���ϰ�, �ٽ� �����ϴ� ������ �Ѵ�.
	class Receiver extends Thread{
		String msg;
		public Receiver() {}
		public Receiver(String msg) {
			this.msg = msg;
		}
		

		@Override
		public void run() {
			for (int i=0;i<10;i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
			
			System.out.println(msg + " Completed");
			
			// Sender Thread�� ���� Client���� �����Ѵ�.
			Sender sender = new Sender(msg);
			sender.start();
			
		}
		
	} //end Receiver
	
	class Sender extends Thread{
		String msg;
		public Sender() {}
		public Sender(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
			System.out.println(msg + " Send Completed");
		}
		
	}
	

}  

// Server class













