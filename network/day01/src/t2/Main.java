package t2;

class T1 extends Thread {
	
	int result=1;
	boolean flag = true;
			
	public int getResult() {
		return this.result;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		while(flag) {
			result++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}


public class Main {
	
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
		int result = 0;
		
		while(result <=20) {	
			//result가 20일때 들고 왔지만,getResult하는 시점에서 21이 될 수 있다. -> 시간차 오차
			result = t1.getResult();  
			System.out.println(result);
			
			if (result == 20) {
				t1.setFlag(false);		//이때 t1쓰레드는 소멸,쓰레드는 한번 소멸되면 다시 살릴수가 없으므로 쓰레드를 새로 생성해야 한다.
				break;
			}
			
		}
	}

}
