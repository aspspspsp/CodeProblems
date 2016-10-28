package Easy;
/*
 * 找兩個數組重複的部分
 * ex:1 2 2 3 4 5, 2 3 5
 * output 2 3 5
 */

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
    	//將兩個數組做排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        //結果暫存
        int[] temp = new int[nums1.length];
        
        int index = 0;
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
            //若兩個數組目前的元素一樣時
            	
            	//將不重複的答案放入暫存結果當中
                if(index == 0 || nums1[i] != temp[index - 1]) {
                    temp[index] = nums1[i];
                    index ++;
                }
                
                //nums1與nums2目前兩個元素一樣時，則nums1與nums2的指標都各加1
                i ++;
                j ++;
            } else if(nums1[i] < nums2[j]) {
            	//nums1目前的元素比nums2目前的元素小時，則nums1的指標+1(為了使nums1與nums2的元素一樣的可能性變大)
                i ++;
            } else if(nums1[i] > nums2[j]) {
            	//nums1目前的元素比nums2目前的元素大時，則nums2的指標+1(為了使nums1與nums2的元素一樣的可能性變大)
                j ++;
            }
        }
        
        int[] result = new int[index];
        
        //將暫存結果輸出至正式結果
        for(int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
    }
}
