package Interview.Concurrent.CopyOnWriteArrayList;

import java.util.List;

public class AddThread implements Runnable {
	private List<Double> list;
	
	public AddThread(List<Double> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i ++) {
			list.add(Math.random());
		}
	}
}