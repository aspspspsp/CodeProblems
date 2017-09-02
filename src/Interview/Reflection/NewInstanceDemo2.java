package Interview.Reflection;

import java.lang.reflect.Constructor;

public class NewInstanceDemo2 {
	public static void main(String[] args) {
		try {
			Class c = Class.forName(args[0]);
			
			// 指定參數型態
			Class[] params = new Class[2];
			// 第一個參數是String
			params[0] = String.class;
			// 第二個參數是int
			params[1] = Integer.TYPE;
			
			// 取得對應參數列的建構方法
			Constructor constructor = c.getConstructor(params);
			
			// 指定引數內容
			Object[] argObjs = new Object[2];
			argObjs[0] = "zihan";
			argObjs[1] = new Integer(90);
		}
	}
}
