package Interview.Concurrent.ReentrantLock;

public class Customer {
	private Depot depot;
	
	public Customer(Depot depot) {
		this.depot = depot;
	}
	
	//���M�aƷ:�½�һ�����̏Ă}�������M�aƷ
	public void consume(final int val) {
		new Thread() {
			public void run() {
				depot.consume(val);
			}
		}.start();
	}
}
