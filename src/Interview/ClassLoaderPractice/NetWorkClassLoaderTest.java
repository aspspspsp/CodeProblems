package Interview.ClassLoaderPractice;

import java.lang.reflect.Method;

public class NetWorkClassLoaderTest {
	public static void main(String[] args) {
		System.out.println("init....");
		try {
			//測試加載網路中的class文件
			String rootUrl = "http://localhost:8080/httpweb/classes";
			String className = "Interview.ClassLoaderPractice.NetClassLoaderSimple";
			NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);
			NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);
			Class<?> clazz1 = ncl1.loadClass(className);
			Class<?> clazz2 = ncl2.loadClass(className);
			Object obj1 = clazz1.newInstance();
			Object obj2 = clazz2.newInstance();
			Method mothod = clazz1.getMethod("setNetClassLoaderSimple", Object.class);
			mothod.invoke(obj1, obj2);
			
			//
			NetworkClassLoader ncl3 = new NetworkClassLoader(rootUrl);
			String className2 = "Interview.ClassLoaderPractice.NetClassLoaderSimple2";
			Class<?> clazz3 = ncl3.loadClass(className2);
			Object obj3 = clazz3.newInstance();
			//運行testMethod
			clazz3.getMethod("testMethod").invoke(obj3);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
