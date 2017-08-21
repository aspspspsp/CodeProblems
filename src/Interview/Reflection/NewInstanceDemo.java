package Interview.Reflection;

import java.util.List;

public class NewInstanceDemo {
	public static void main(String[] args) {
		try {
			Class c = Class.forName(args[0]);
			List list = (List)c.newInstance();
			
			for(int i = 0; i < 5; i ++) {
				list.add("element " + i);
			}
			
			for(Object o : list.toArray()) {
				System.out.println(o);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("找不到指定類別");
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
