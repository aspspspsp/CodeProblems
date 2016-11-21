package Medium;

/*
�������ʵ�ò���������������ɨ��һ���м���0������1������2�Ϳ����ˣ�Ȼ�������ʱ�򣬰���0��1��2ͳ�Ƶĸ�����˳��ĸ�ֵ������Ϳ����ˡ�
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