package Interview.Concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * �yԇ����
 * @author zihanxu
 *
 */

public class WorkerTestThread implements Runnable {
	private Worker worker;
	private CountDownLatch cdLatch;
	
	public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
		this.worker = worker;
		this.cdLatch = cdLatch;
	}

	@Override
	public void run() {
		this.worker.doWork(); //׌�����_ʼ����
		this.cdLatch.countDown(); //��ɹ����ᣬ����Ӌ�r�Δ�-1
	}
	
	
}
