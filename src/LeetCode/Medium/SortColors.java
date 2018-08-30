package src.LeetCode.Medium;

/*
這道題其實用不到排序，首先我們掃描一下有幾個0，幾個1，幾個2就可以了，然後輸出的時候，按照0，1，2統計的個數，順序的賦值給數組就可以了。
*/
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        int numOfRed = 0;
        int numOfWhite = 0;
        int numOfBlue = 0;
        
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0)
                numOfRed ++;
            else if(nums[i] == 1)
                numOfWhite ++;
            else
                numOfBlue ++;
        }
        
        int i = 0;
        while(numOfRed > 0) {
            nums[i] = 0;
            numOfRed --;
            i ++;
        }
        
        while(numOfWhite > 0) {
            nums[i] = 1;
            numOfWhite --;
            i ++;
        }
        
        while(numOfBlue > 0) {
            nums[i] = 2;
            numOfBlue --;
            i ++;
        }
    }
}