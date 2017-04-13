package LeetCode.Medium;

import java.util.Random;

/*
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

solution.pick(3); 
//���e���ҵ�3��index����3��index��2��3�c4���@�rҪ��ͬ���ʵķ���2��3��4

solution.pick(1);
//���e���ҵ�1��index����1��indexֻ��0���@�rֻҪ����0
*/
public class RandomPickIndex {
    int[] nums;
    Random random; 
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    /*
    ���Ƕ�����������:
    ����up_bound
    ���ؽ��result
    ���Ǳ����������飬��������ֵ������target��ֱ��������
    �������target����������1��
    Ȼ��������[0,up_bound]��Χ���������һ�����֣�
    ������������0�����ǽ�result��ֵΪi����
    */
    
    public int pick(int target) {
        int result = -1;
        
        //ˮ����ӿ���kȡ�ӵĹ���
        int up_bound = 1;
        
        //��v�������M
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == target) {
            	//�M��ˮ�����(1/k)�ĸ��ʣ��Ƿ�����@��index
                if(random.nextInt(up_bound) == 0)
                    result = i; 
                //��k�Ĺ�������
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