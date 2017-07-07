package Interview.Concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * 測試線程
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
		this.worker.doWork(); //讓工人開始工作
		this.cdLatch.countDown(); //完成工作後，倒數計時次數-1
	}
	
	
}
