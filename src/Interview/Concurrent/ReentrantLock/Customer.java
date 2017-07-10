package Interview.Concurrent.ReentrantLock;

public class Customer {
	private Depot depot;
	
	public Customer(Depot depot) {
		this.depot = depot;
	}
	
	//消費產品:新建一個線程從倉庫中消費產品
	public void consume(final int val) {
		new Thread() {
			public void run() {
				depot.consume(val);
			}
		}.start();
	}
}
