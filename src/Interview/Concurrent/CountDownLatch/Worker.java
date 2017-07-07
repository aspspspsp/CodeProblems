package Interview.Concurrent.CountDownLatch;
/**
 * Worker
 * @author zihanxu
 *
 */
public class Worker {
	private String name; //名字
	private long workDuration; //工作持續時間
	
	/**
     * 建構子
     */
	public Worker(String name, long workDuration) {
		this.name = name;
		this.workDuration = workDuration;
	}
	
	/**
	 * 進行工作
	 */
	public void doWork() {
		System.out.println(name + " begin to work...");
		try {
			Thread.sleep(workDuration);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(name + " has finished the job...");
	}
}
