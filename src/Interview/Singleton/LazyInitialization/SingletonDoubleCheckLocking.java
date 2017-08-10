package Interview.Singleton.LazyInitialization;

public class SingletonDoubleCheckLocking {
	private static volatile SingletonDoubleCheckLocking instance = null;
	private SingletonDoubleCheckLocking() {
		
	}
	
	public static SingletonDoubleCheckLocking getInstance() {
		if(instance == null)
			synchronized (SingletonDoubleCheckLocking.class) {
				if(instance == null) {
					instance = new SingletonDoubleCheckLocking();
				}
			}
					
		return instance;
	}
	
}
