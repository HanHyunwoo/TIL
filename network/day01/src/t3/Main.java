package t3;

import java.util.Scanner;

class Receiver implements Runnable{
	String cmd;
	
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	@Override
	public void run() {
		while(true) { 
			//while 너무 빨리 돈다. 그래서 cmd가 바꼇어도 cmd가 들어가지 않고 막 while이 돈다.
			//그래서 잠깐 while문에 파고들  0.001초 틈을 준다~!
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if(cmd != null && cmd.equals("s")) {
				// Send Message
				for(int i=0;i<=50;i++) {
					System.out.println(i);
					
					if(cmd != null && cmd.equals("e")) {
						break;
					}
					
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Send Message End ....
				
			}

//			while문을 궂이 안죽여도 된다.
//			if(cmd != null && cmd.equals("e")) {
//				break;
//			}
			
		}
	}
	
}



public class Main {
	public static void main(String[] args) {
		Receiver r = new Receiver();
		Thread t = new Thread(r);
		t.start();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Cmd s");
		String cmd = sc.nextLine();
		r.setCmd(cmd.trim());
		System.out.println("Main ....");
		
		System.out.println("Input Cmd e");
		String cmd2 = sc.nextLine();
		r.setCmd(cmd2.trim());
		
		sc.close();
	}
}
