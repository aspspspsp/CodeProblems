package Interview.Concurrent.ArrayList;

import java.util.List;

/**
 * Éú®aÕß
 * @author zihanxu
 *
 */
public class Producer implements Runnable {
	private List<Task> buffer;
	
	public Producer(List<Task> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(true) {
			synchronized(buffer) {
				while(buffer.size() >= Constants.MAX_BUFFER_SIZE) {
					try {
						buffer.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				Task task = new Task();
				buffer.add(task);
				buffer.notifyAll();
				System.out.println("Producer[" + Thread.currentThread().getName() + "] put " + task);
			}
		}
	}
	
}
