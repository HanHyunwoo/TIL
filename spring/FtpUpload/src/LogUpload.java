
public class LogUpload implements Runnable {
	LogUpload() {
		System.out.println("������ ����");
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(3600);
				

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	
	

}
