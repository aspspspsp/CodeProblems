package LeetCode.Easy;
/*
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

�oһ����и�һ�����֣��Ƴ���������и�������ͬ��Ԫ�ء�
������ʹ���������Ё�̎��ȫ���Ĳ�����Ҫ��ͬһ������С�
����е�Ԫ�ؿ����S������
������  
nums = [3, 1, 2, 3, 2] 要刪除的目標為 val = 3  
經過歷遍之後 return ��е��L��3������e���3���Ƴ���ʣ[1,2,2].
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
    	//將非要刪除的數字往前挪，蓋過要刪除的數字
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