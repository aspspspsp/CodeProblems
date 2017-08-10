package Interview.Singleton.LazyInitialization;

public class SingletonBasic {
	private static SingletonBasic instance = null;
	
	private SingletonBasic() {
		
	}
	
	public static SingletonBasic getInstange() {
		if(instance == null)
			instance = new SingletonBasic();
		return instance;
	}
}
