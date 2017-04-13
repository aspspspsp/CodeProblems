package Singleton;

public class SingletonDoubleCheckLocking {
	private static SingletonDoubleCheckLocking instance = null;
	private SingletonDoubleCheckLocking() {
		
	}
	
	private static SingletonDoubleCheckLocking getInstance() {
		if(instance == null)
			if(instance == null)
				synchronized (SingletonDoubleCheckLocking.class) {
					if(instance == null) {
						instance = new SingletonDoubleCheckLocking();
					}
				}
					
		return instance;
	}
	
}
