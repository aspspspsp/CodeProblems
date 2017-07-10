package Interview.Concurrent.ReentrantLock;

public class LockTest {
	public static void main(String[] args) {
		Depot mDepot = new Depot(100);
		Producer mPro = new Producer(mDepot);
		Customer mCus = new Customer(mDepot);
		
		mPro.produce(60);
		mPro.produce(120);
		mCus.consume(90);
		mCus.consume(150);
		mPro.produce(110);
	}
}
