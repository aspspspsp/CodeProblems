package src.LeetCode.Hard;

/*
下面我们说说优化的算法。这种方法是基于动态规划的，基本思路就是维护一个长度为n的数组，进行两次扫描，
一次从左往右，一次从右往左。第一次扫描的时候维护对于每一个bar左边最大的高度是多少，存入数组对应元素
中，第二次扫描的时候维护右边最大的高度，并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组对
应元素中。这样两遍扫描之后就可以得到每一个bar能承受的最大水量，从而累加得出结果。这个方法只需要两
次扫描： 
*/
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        
        int result = 0;
        int[] container = new int[height.length];
        
        int max = 0;
        for(int i = 0; i < height.length; i ++) {
            container[i] = max;
            max = Math.max(max, height[i]);
        }
        
        max = 0;
        for(int i = height.length - 1; i >= 0; i --) {
            container[i] = Math.min(max, container[i]);
            max = Math.max(max, height[i]);
            
            if(container[i] - height[i] > 0)
                result += container[i] - height[i];
        }
        
        return result;
        
    }
}