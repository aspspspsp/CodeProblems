package src.LeetCode.Algorithms.Easy;
/*
將nums1與num2兩個數組合併到一個數組上，num1即為兩個數組合併的結果
因為nums1的空間可以容納合併後的結果，所以nums1的空間為m + n - 1
若目前拜訪nums1的元素>目前拜訪nums2的元素，把nums1目前的元素放到
nums1目前範圍的最後面(m + n - 1)，nums1的指針往前(nums2目前拜訪的
元素已排序)
反之若目前拜訪nums1的元素<目前拜訪nums2的元素把nums2目前的元素放到
nums1目前範圍的最後面(m + n - 1)，nums2的指針往前(nums2目前拜訪的
元素已排序)
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	//一起歷遍nums1與nums2兩個數組，由後往前歷遍
        while(m > 0 && n > 0) {
        	//若目前拜訪nums1的元素>目前拜訪nums2的元素，把nums1目前
        	//的元素放到nums1目前範圍的最後面(m + n - 1)
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m --;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n --;
            }
        }
        
        //處理nums2剩下的元素，放入nums1中
        while(n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n --;
        }
    
    }
}