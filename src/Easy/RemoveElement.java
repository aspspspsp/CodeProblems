package Easy;
/*
val = 3

init.
index = 0 1 2 3 
----------------
nums  = 3 2 2 3

step 1.
count = 0
index = 0* 1 2 3 
----------------
nums  = 3* 2 2 3

step 2.
count = 1
index = 0| 1* 2 3 
------------------
nums  = 2| 2* 2 3

step 3.
count = 2
index = 0 1| 2* 3 
------------------
nums  = 2 2| 2* 3

step 4.
count = 2
index = 0 1| 2 3* 
------------------
nums  = 2 2| 2 3*

給一個陣列跟一個數字，移除陣列中所有跟數字相同的元素。
不可以使用另外的陣列來處理，全部的操作都要在同一個陣列中。
陣列中的元素可以隨意排序。
範例：  
nums = [3, 1, 2, 3, 2]， val = 3  
應該要return 陣列的長度3，因為裡面的3被移除後剩[1,2,2].
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //紀錄這個陣列結果的大小
        int count = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}