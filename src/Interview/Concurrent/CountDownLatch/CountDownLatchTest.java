package Interview.Concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private static final int MAX_WORK_DURATION = 5000; //最大工作時間
	private static final int MIN_WORK_DURATION = 1000; //最小工作時間
	
	//產生隨機的工作時間
	private static long getRandomWorkerDuration(long min, long max) {
		return (long) (Math.random() * (max - min) + min);
	}
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2); //創建倒數計時器的閥值，並指定為2
		Worker w1 = new Worker("Slave1", getRandomWorkerDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w2 = new Worker("Slave2", getRandomWorkerDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		
		new Thread(new WorkerTestThread(w1, latch)).start();
		new Thread(new WorkerTestThread(w2, latch)).start();
		
		try {
			latch.await(); //等待倒數計時器減到0
			System.out.println("All jobs have been finished!");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
