package t1;
import java.util.Scanner;

public class Server {	
	boolean flag = true;
	
	public void startServer(){
		Scanner client = new Scanner(System.in);
		
		while(flag) {
			System.out.println("Server Ready");
			String msg = client.nextLine();  //nextLine때문에 멈춤, 기다리는거임~
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

	
	// 요청을 받아서 처리하고, 다시 전송하는 역할을 한다.
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
			
			// Sender Thread를 통해 Client에게 전송한다.
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













