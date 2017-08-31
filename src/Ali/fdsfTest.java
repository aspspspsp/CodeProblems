package Ali;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;
class Main {
/** 请完成下面这个process函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
	private static int process(HashMap<Integer, Integer> map) 
	{
		
    	return 0;
	}
	
	class M {		
		public int price;
		public int size;
		public M(int l, int h, int price) {
			size = l * h;
			this.price = price;
		}
	}
	
	//price 體積
	public static void main(String args[]){
	        Scanner scanner = new Scanner(System.in);
	        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;
	        

	        while (scanner.hasNext()){
	            boxTemplate.length = scanner.nextInt();
	            boxTemplate.width = scanner.nextInt();
	            boxTemplate.height = scanner.nextInt();
	
	            int itemNum = scanner.nextInt();
	            items = new Model[itemNum];
	            for(int i=0; i<itemNum; i++){
	                Model item = new Model();
	                item.price = scanner.nextInt();
	                item.length = scanner.nextInt();
	                item.width = scanner.nextInt();
	                item.height = scanner.nextInt();
	                items[i] = item;
	            }
	            long startTime = System.currentTimeMillis();
	            boxMinNum = Integer.MAX_VALUE;
	        	HashMap<Integer, Integer> map = new HashMap<>();
	            System.out.println (process());
	        }
	}

   }