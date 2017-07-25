package Ali;
import java.util.Scanner;
/*
 * 小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。
 * 小猴子想摘桃子，但是有一些条件需要遵守，小猴子只能沿着下山
 * 的方向走，不能回头，每颗树最多摘一个，而且一旦摘了一棵树的
 * 桃子，就不能再摘比这棵树结的桃子少的树上的桃子。那么小猴子
 * 最多能摘到几颗桃子呢？
 */
public class AliProgrammingTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		
		int[] s = new int[a];
		int[] length = new int[a];

		for(int i = 0; i < a; i ++)
			s[i] = in.nextInt();
		
	    for (int i=0; i<a; i++)
	    	length[i] = 1;
	 
	    for (int i=0; i<a; i++)
	        for (int j=i+1; j<a; j++)
	            if (s[i] < s[j])
	                length[j] = Math.max(length[j], length[i] + 1);
	 
	    int n = 0;
	    for (int i=0; i<a; i++)
	        n = Math.max(n, length[i]);
	    
	    System.out.println(n);
	}
}
