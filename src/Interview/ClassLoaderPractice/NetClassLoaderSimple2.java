package Interview.ClassLoaderPractice;

public class NetClassLoaderSimple2 {
	public NetClassLoaderSimple2() {
		System.out.println(this.getClass().toString() + " is loaded!");
	}
	public void testMethod(int test) {
		System.out.println("run test method");
	}
}
