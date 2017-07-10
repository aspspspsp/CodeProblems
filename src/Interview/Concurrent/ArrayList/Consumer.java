package Interview.Concurrent.ArrayList;

import java.util.List;

/**
 * ЯћйMеп
 * @author zihanxu
 *
 */
public class Consumer implements Runnable{
	private List<Task> buffer;
	
	public Consumer(List<Task> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(true) {
			synchronized(buffer) {
				while(buffer.isEmpty()) {
					try {
						buffer.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				Task task = buffer.remove(0);
				buffer.notifyAll();
				System.out.println("Consumer[" + Thread.currentThread().getName() + "] got " + task);
			}
		}
	}
}
