package Interview.Reflection;

public class ForNameDemoV2 {
	public static void main(String[] args) {
		try {
			System.out.println("載入TestClass2");
			Class c = Class.forName(
					"Interview.Reflection.TestClass2",
					false, //載入類別時不載入靜態方法
					Thread.currentThread().getContextClassLoader());
			
			System.out.println("使用TestClass2宣告參考名稱");
			TestClass2 test = null;
			
			System.out.println("使用TestClass2建立物件");
			test = new TestClass2();
		} catch(ClassNotFoundException e) {
			System.out.println("找不到指定的類別");
		}
	}
}