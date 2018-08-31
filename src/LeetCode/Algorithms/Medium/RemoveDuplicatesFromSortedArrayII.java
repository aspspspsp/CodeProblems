package src.LeetCode.Algorithms.Medium;
public class RemoveDuplicatesFromSortedArrayII {
    /*
這題是將數組中一樣的元素去除，故有兩個指針:
1.指向目前元素(i)
2.指向目前沒有重複的元素(j)

但要加上三個限制條件:
1.若元素不重複(進行指針移動)
	則numOfElements為1
	nums[j] = nums[i]
	j ++
2.若元素重複，且numOfElements為1(進行指針移動)
	則numOfElements為2
	nums[j] = nums[i]
	j ++
2.若元素重複，且numOfElements為2級以上
	跳過這回合
    ex:
      1,1,1,2,3,4,5
step1 i=1,j=0
      1,1,1,2,3,4,5
step2 i=2,j=1
      1,1,1,2,3,4,5
step3 i=3,j=1
      1,1,1,2,3,4,5 
step4 i=4,j=2
      1,1,2,2,3,4,5 
step5 i=5,j=3
      1,1,2,3,3,4,5 
step6 i=6,j=4
      1,1,2,3,4,4,5
step7 i=7,j=5
      1,1,2,3,4,5,5 
step8 i=8,j=6
      1,1,2,3,4,5,5 
    */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return 1;
        
        int numOfElements = 1;
        int n = nums.length;
        int j = 0;
        
        //歷遍數組所有元素(這種題可以從統一從1比較)
        for(int i = 1; i < n; i ++) {
            if(nums[i] == nums[j] && numOfElements > 1) {
                numOfElements ++;
                continue;
            }
            
            if(nums[i] == nums[j] && numOfElements == 1) {
                j ++;
                nums[j] = nums[i];
                numOfElements ++;
                continue;
            }
            
            if(nums[i] != nums[j]) {
                j ++;
                nums[j] = nums[i];
                numOfElements = 1;
            }
        }
        
        return j + 1;
    }
}