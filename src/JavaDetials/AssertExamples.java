package JavaDetials;
/*
 * 開啟eclipse的assert功能請參見：
 * http://stackoverflow.com/questions/11415160/how-to-enable-the-java-keyword-assert-in-eclipse-program-wise
 */
public class AssertExamples {
	public static void main(String[] args) {
		//String name = "abner chai";
		String name = null;
		//當assert的條件為false時，則會返回例外(並顯示"变量name为空null")
		assert (name != null) : "变量name为空null";
		System.out.println(name);
	}
}
