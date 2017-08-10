package Interview.Singleton.LazyInitialization;

public class SingletonSynchronized {
	private static SingletonSynchronized instance = null;
	
	private SingletonSynchronized() {
		
	}
	
	public static synchronized SingletonSynchronized getInstange() {
		if(instance == null)
			instance = new SingletonSynchronized();
		return instance;
	}
}
