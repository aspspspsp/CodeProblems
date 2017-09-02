

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class A1 {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
        	String a = in.nextLine();
        	char[] r = a.toCharArray();
        	boolean[] iaa = new boolean[r.length];
        
        	for(int i = 3; i < a.length(); i ++) {
        		if(a.charAt(i) == '@' && 
        				a.charAt(i - 1) != '@'  &&
        				a.charAt(i - 2) != '@'  &&
        				a.charAt(i - 3) != '@'  &&
        				a.charAt(i - 1) != '.'  &&
        				a.charAt(i - 2) != '.'  &&
        				a.charAt(i - 3) != '.'  &&
        				a.charAt(i - 1) != '*'  &&
                		a.charAt(i - 2) != '*'  &&
                		a.charAt(i - 3) != '*'  &&
        				iaa[i - 1] == false &&
        				iaa[i - 2] == false &&
        				iaa[i - 3] == false) {
        			r[i - 1] = '*';
        			r[i - 2] = '*';
        			r[i - 3] = '*';
        			iaa[i - 1] = true;
        			iaa[i - 2] = true;
        			iaa[i - 3] = true;
        		}
        	}
        	
        	String res = "";
        	for(int i = 0; i < r.length; i ++) {
        		res += r[i];
        	}
        	
        	System.out.println(res);
        }
    }
}