package src.LeetCode.Easy;
/*
 * 這題是將數組中一樣的元素去除，故有兩個指針:
 * 1.指向目前元素(i)
 * 2.指向目前沒有重複的元素(j)
 * 
 * 
指針: i, j 不含有重複元素的數組指針
ex1:                     ex2: 
======================================
step1 i = 1; j = 0 j++ | step1 i = 1; j = 0 j++
      1,1,1,2,3,4      |       1,2,3,3,4  
step2 i = 2; j = 0     | step2 i = 2; j = 1 j++
      1,1,1,2,3,4      |       1,2,3,3,4 
step3 i = 3; j = 1 j++ | step3 i = 3; j = 2
      1,2,1,2,3,4      |       1,2,3,3,4
step4 i = 4; j = 2 j++ | step4 i = 4; j = 2 j++
      1,2,3,2,3,4      |       1,2,3,4,4
step5 i = 4; j = 3 j++
      1,2,3,4,3,4    
step6 i = 5; j = 4 j++
      1,2,3,4,3,4
 *      返回j指針，表示去重後的元素大小
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	//這個指針指向目前沒有重複的元素
        int j = 0;
        
        //歷遍數組所有元素(這種題可以從統一從1比較)
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == nums[j]) {
            	//使指針j不更新
                continue;
            }
            j ++;
            nums[j] = nums[i];
        }
        
        //返回去重後的數組長度
        return j + 1;
    }

}