package thread;

import java.util.Random;

public class Producer implements Runnable {
	BlockedQueue bc;
	static int count = 0;

	Producer(BlockedQueue b) {
		this.bc = b;
	}

	@Override
	public void run() {
		while (count < 100) {
			Random rand = new Random();
			bc.add(rand.nextInt(100));
			count ++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
