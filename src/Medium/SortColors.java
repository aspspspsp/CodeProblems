package Medium;

/*
这道题其实用不到排序，首先我们扫描一下有几个0，几个1，几个2就可以了，然后输出的时候，按照0，1，2统计的个数，顺序的赋值给数组就可以了。
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