package Interview.Concurrent.CountDownLatch;
/**
 * Worker
 * @author zihanxu
 *
 */
public class Worker {
	private String name; //����
	private long workDuration; //�������m�r�g
	
	/**
     * ������
     */
	public Worker(String name, long workDuration) {
		this.name = name;
		this.workDuration = workDuration;
	}
	
	/**
	 * �M�й���
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
