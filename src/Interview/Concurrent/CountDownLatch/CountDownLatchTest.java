package Interview.Concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private static final int MAX_WORK_DURATION = 5000; //������r�g
	private static final int MIN_WORK_DURATION = 1000; //��С�����r�g
	
	//�a���S�C�Ĺ����r�g
	private static long getRandomWorkerDuration(long min, long max) {
		return (long) (Math.random() * (max - min) + min);
	}
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2); //��������Ӌ�r�����yֵ���Kָ����2
		Worker w1 = new Worker("Slave1", getRandomWorkerDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		Worker w2 = new Worker("Slave2", getRandomWorkerDuration(MIN_WORK_DURATION, MAX_WORK_DURATION));
		
		new Thread(new WorkerTestThread(w1, latch)).start();
		new Thread(new WorkerTestThread(w2, latch)).start();
		
		try {
			latch.await(); //�ȴ�����Ӌ�r���p��0
			System.out.println("All jobs have been finished!");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
