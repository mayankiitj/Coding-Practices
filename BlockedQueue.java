package thread;

import java.util.List;
import java.util.Vector;

public class BlockedQueue {
	List<Integer> queue = new Vector<Integer>();
	int size = 5;

	public synchronized void add(int val) {
		while (queue.size() >= 5) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queue.add(val);
		notifyAll();
		System.out.println("Produced !! size is "+queue.size());

	}
	
	public synchronized void remove() {
		while (queue.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queue.remove(0);
		notifyAll();
		System.out.println("Consumed !! size is "+queue.size());

	}
	
	public static void main(String args[]){
		BlockedQueue bin = new BlockedQueue();
		Producer pr = new Producer(bin);
		Consumer cr = new Consumer(bin);
		
		new Thread(pr).start();
		new Thread(cr).start();
	}
	
}
