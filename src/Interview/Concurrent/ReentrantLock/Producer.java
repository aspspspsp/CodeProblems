package Interview.Concurrent.ReentrantLock;

public class Producer {
	private Depot depot;
	
	public Producer(Depot depot) {
		this.depot = depot;
	}
	
	//消費產品:新建一個線程向倉庫中生產產品
	public void produce(final int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}
