package Interview.ClassLoaderPractice;

public class NetClassLoaderSimple {
	private NetClassLoaderSimple instance;
	
	public void setNetClassLoaderSimple(Object obj) {
		this.instance = (NetClassLoaderSimple)obj;
		System.out.println("run method");
	}
}
