
public class A {
	public static void main(String[] args) {
		
		String a = "/a/./b/../../c/";
		String[] aa = a.split("/");
		for(int i = 0; i < aa.length; i ++)
			System.err.println(aa[i]);
	}
}
