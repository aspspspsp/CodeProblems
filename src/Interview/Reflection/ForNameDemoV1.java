package Interview.Reflection;

public class ForNameDemoV1 {
	public static void main(String[] args) {
		try {
			System.out.println("載入TestClass2");
			Class c = Class.forName("Interview.Reflection.TestClass2");
			
			System.out.println("使用TestClass2宣告參考名稱");
			TestClass2 test = null;
			
			System.out.println("使用TestClass2建立物件");
			test = new TestClass2();
		} catch(ClassNotFoundException e) {
			System.out.println("找不到指定的類別");
		}
	}
}

class TestClass2 {
	static {
		System.out.println("[執行靜態區塊]");
	}
}