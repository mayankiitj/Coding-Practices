package thread;

import java.util.Random;

public class Consumer implements Runnable{
	BlockedQueue bc;
	static int count = 0;
	
	public Consumer(BlockedQueue b) {
		this.bc =b;
	}
	@Override
	public void run() {
		while (count < 100) {
			bc.remove();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count ++;
		}
	}

}
