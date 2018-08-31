package src.LeetCode.Medium;

import java.util.Random;

/*
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

solution.pick(3); 
//從裡面找到3的index，而3的index有2、3與4，這時要相同概率的返回2、3或4

solution.pick(1);
//從裡面找到1的index，而1的index只有0，這時只要返回0
*/
public class RandomPickIndex {
    int[] nums;
    Random random; 
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    /*
    我们定义两个变量:
    计数up_bound
    返回结果result
    我们遍历整个数组，如果数组的值不等于target，直接跳过；
    如果等于target，计数器加1，
    然后我们在[0,up_bound]范围内随机生成一个数字，
    如果这个数字是0，我们将result赋值为i即可
    */
    
    public int pick(int target) {
        int result = -1;
        
        //ˮ����ӿ���kȡ�ӵĹ���
        int up_bound = 1;
        
        //遍歷整個數組
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == target) {
            	//�M��ˮ�����(1/k)�ĸ��ʣ��Ƿ�����@��index
                if(random.nextInt(up_bound) == 0)
                    result = i; 
                //進行水塘抽樣
                up_bound ++;
            }
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */