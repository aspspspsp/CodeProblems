package src.LeetCode.Algorithms.Hard;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
  /*
     *  A line is determined by two factors,say y=ax+b
     *  
     *  If two points(x1,y1) (x2,y2) are on the same line(Of course). 

     *  Consider the gap between two points.

     *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

     *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

     *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  So we can use y0&x0 to track a line;
     */
 public class MaxPointsOnALine{
        public int maxPoints(Point[] points) {
        	if(points == null)
        	    return 0;
        	if(points.length <= 2)
        	    return points.length;
        	
        	Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        	int gobal_max = 0; //紀錄全域最大
        	for(int i = 0; i < points.length; i ++){ 
        		map.clear();
        		int overlap = 0;
        		int local_max = 0;  //紀錄部分最大
        		for(int j = i + 1; j < points.length; j ++){
        		    //計算兩點x,y的長度
        			int x = points[j].x - points[i].x;
        			int y = points[j].y - points[i].y;
        			
        			//計算重疊的點
        			if (x == 0 && y== 0){
        				overlap ++;
        				continue;
        			}
        			
        			int gcd = generateGCD(x, y);
        			if(gcd != 0){
        				x = x / gcd;
        				y = y / gcd;
        			}
        			
        			if(map.containsKey(x)){
        				if(map.get(x).containsKey(y)) {
        					map.get(x).put(y, map.get(x).get(y) + 1);
        				} else {
        					map.get(x).put(y, 1);
        				}   					
        			} else {
        				Map<Integer, Integer> m = new HashMap<>();
        				m.put(y, 1);
        				map.put(x, m);
        			}
        			local_max = Math.max(local_max, map.get(x).get(y));
        		}
        		gobal_max = Math.max(gobal_max, local_max + overlap + 1);
        	}
        	return gobal_max;
        }
        
        private int generateGCD(int a, int b){
        	if(b == 0)
        	    return a;
        	else
        	    return generateGCD(b, a % b);
        	
        }
    }
