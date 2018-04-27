package t1;

class Thread1 extends Thread{
	String msg;
	boolean flag=true;
	
	public Thread1(String msg) {
		this.msg = msg;
		
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {  //쓰레드가 진행되어지는 영역
		int i = 0;
		while(flag) {
			System.out.println("Thread1  " + msg + " " + i++);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



class Thread2 implements Runnable{
	String msg;
	boolean flag=true;
	
	public Thread2(String msg) {
		this.msg = msg;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() { //쓰레드가 진행되어지는 영역
		int i = 0;
		while(flag) {
			System.out.println("               Thread2  " + msg+ " " +i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}



public class T1 {

	public static void main(String[] args) throws InterruptedException {
		//핸들러,어씽크테스트는 안드로이드에만 있따.자바에는 없다
		Thread1 t1 = new Thread1("T1"); 
		Thread2 r = new Thread2("t2");
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		Thread.sleep(5000);
		t1.setFlag(false);
		r.setFlag(false);
		
	}

}
 