
import java.util.Scanner;
public class A3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
          
            String a1 = a + "";
            String b1 = b + "";
            
            if(a1.length() != b1.length()) {
            	System.out.println(-1);
            	continue;
            }
            
            int cnt = 0;
            int max = 0;
            for(int i = 0; i < a1.length(); i ++) {
            	String s_a = a1.substring(i, i + 1);
            	String s_b = b1.substring(i, i + 1);
            	
            	if(s_a.equals(s_b)) {
            		cnt ++;
            	} else {
            		cnt = 0;
            	}
            	
            	if(max < cnt)
            		max = cnt;
            }
            
            System.out.println(max);
        }
    }
}