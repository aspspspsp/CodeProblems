package Medium;
/*
 思路：

设 x1为到目前为止的最小值 ，  x2为到目前为止至少有一个数比x2小的最小的数。

初始时设置x1 = x2 = INT_MAX ，然后遍历数组,不断的更新x1和x2 具体如下

num <= x1,  此时将x1设置为num
若 x1 < num <= x2，则 把x2 设置为num
x2 < num  说明有解，返回true即可
简单的说，上述的过程就是不断的缩小x1和x2，看看是否有第三个数 比x2大。

如果出现第三个数 num > x2，则之前必定还有个数x 小于x2，就是说满足 x < x2 < num，就是说有答案啦。
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    	int x1 = 0x7fffffff; //设置x1 = INT_MAX
    	int x2 = 0x7fffffff; //设置x2 = INT_MAX
    	
        for(int num : nums) {
        	if(num <= x1) //若這個數比第一個數小則更新x1
        		x1 = num; //更新第一個數
        	else if(num <= x2) //若這個數比第二個數小則更新x2
        		x2 = num; //更新第二個數
        	else  //若這個數比前面兩個數都大則是 x1 < x2 < x3
        		return true; //然後返回true
        }
        return false;
    }
}
