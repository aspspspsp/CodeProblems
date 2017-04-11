package Singleton;

public class SingletonLazyInitialization {
	private static SingletonLazyInitialization instance = null;
	
	private SingletonLazyInitialization() {
		
	}
	
	public SingletonLazyInitialization getInstange() {
		if(instance == null)
			instance = new SingletonLazyInitialization();
		return instance;
	}
}
