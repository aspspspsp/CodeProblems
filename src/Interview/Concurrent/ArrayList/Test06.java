package Interview.Concurrent.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test06 {
	public static void main(String[] args) {
		List<Task> buffer = new ArrayList<>(Constants.MAX_BUFFER_SIZE);
		ExecutorService es = Executors.newFixedThreadPool(Constants.NUM_OF_CONSUMER + Constants.MUM_OF_PRODUCER);
		for(int i = 1; i <= Constants.MUM_OF_PRODUCER; i ++) {
			es.execute(new Producer(buffer));
		}
		
		for(int i = 1; i <= Constants.NUM_OF_CONSUMER; i ++) {
			es.execute(new Consumer(buffer));
		}
	}
}
