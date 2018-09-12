package src.LeetCode.Algorithms.Easy;
/*
在這題當中，就是要刪除指定的元素，所以當遇到要刪除的元素時，我們會將指標向前挪動，直到
後面不要刪除的元素，然後利用該元素覆蓋當前的元素，最後返回經過刪除後的數組大小，下面為
一個例子:
nums = [3, 1, 2, 3, 2] 要刪除的目標為 val = 3
經過歷遍之後，我們返回的數組為:[1,2,2]
==================================
實例演示:
數組:[3,2,2,3]
刪除的元素:3
=====(步驟)=====
val = 3 <-要刪除的元素

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

然後返回count，也就是經過刪除後的數組大小
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0; //紀錄刪除後的數組大小
        for(int i = 0; i < nums.length; i ++) {
            //將非要刪除的數字(後面)往前挪，蓋過要刪除的數字
            if(nums[i] != val) {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}