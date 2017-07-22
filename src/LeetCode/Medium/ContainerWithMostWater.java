package LeetCode.Medium;

public class ContainerWithMostWater {
    /*
    首先，我們可以假設結果為0。然後我們可以掃描左右兩側(利用左右兩指針)。
    若左邊柱子高度大於右邊柱子的高度，移動右指針，向左搜索，找到大於目前左邊柱子的高度值
    若右邊柱子高度大於左邊柱子的高度，移動左指針，向右搜索，找到大於目前右邊柱子的高度值
    此外必須要維護一個目前最大值。
    
    ->                  <-
                      |
          |           |  |
       |  |  |     |  |  |
    |  |  |  |  |  |  |  |
    |  |  |  |  |  |  |  |
    ______________________
    */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        
        //假設目前結果為0
        int max = 0;
        
        //左右兩指針
        int left = 0;
        int right = height.length - 1;
        
        while(left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            
            //移動指針
	    //移動左指針，向右搜索，找到大於目前右邊柱子的高度值
            if(height[left] < height[right]) {
                left ++;
            }
	    //移動右指針，向左搜索，找到大於目前左邊柱子的高度值
	    else {
                right --;
            }
        }
        
        return max;
    }
}