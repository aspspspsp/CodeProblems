package Interview.Concurrent.ArrayList;

import java.util.UUID;

public class Task {
	private String id; //�΄յľ�̖
	
	public Task() {
		this.id = UUID.randomUUID().toString();
	}
	
	@Override
	public String toString() {
		return "Task[" + id + "]";
	}
}
