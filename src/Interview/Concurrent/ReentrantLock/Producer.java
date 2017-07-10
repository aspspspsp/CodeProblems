package Interview.Concurrent.ReentrantLock;

public class Producer {
	private Depot depot;
	
	public Producer(Depot depot) {
		this.depot = depot;
	}
	
	//���M�aƷ:�½�һ��������}�������a�aƷ
	public void produce(final int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}
