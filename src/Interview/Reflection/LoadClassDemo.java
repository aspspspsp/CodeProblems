package Interview.Reflection;

public class LoadClassDemo {
    public static void main(String args[])
    {
    	TestClass test = null;
    	System.out.println("宣告TestClass參考名稱");
    	test = new TestClass();
    	System.out.println("生成TestClass實例");
    }
    
}

class TestClass {
	static {
		System.out.println("類別已被載入");
	}
}
