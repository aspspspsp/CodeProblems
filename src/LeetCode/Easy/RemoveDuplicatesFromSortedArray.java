package LeetCode.Easy;
/*
 * 這題是將數組中一樣的元素去除，故有兩個指針:
 * 1.指向目前元素(i)
 * 2.指向目前沒有重複的元素(end)
 * 
 * ex: 
 * 數組內容:1,2,2,2,3
 * 指針: i, end   元素情況
 * ==========================
 *      0,0       1 2 2 3 4
 *      1,1       1 2 2 3 4
 *      2,2       1 2 2 3 4
 *      3,2       1 2 3 4 4
 *      4,3       1 2 3 4 4
 *      返回end指針
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	//這個指針指向目前沒有重複的元素
        int end = 0;
        
        //歷遍數組所有元素
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == nums[end]) {
            	//使指針end不更新
                continue;
            }
            end ++;
            nums[end] = nums[i];
        }
        
        //返回去重後的數組長度
        return end + 1;
    }

}