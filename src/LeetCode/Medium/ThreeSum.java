package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //�Ȍ����M�M������(�Է����M�ЊA��)
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        /*
        i �M��ѭ��v��
        j ��i�M�����ҊA��
        k �ɔ��M����һ���M������A��
        
        ��nums[i] + nums[j] + nums[k] == 0
        �t����ԓ�Y��
        �K��׌i�cjָᘸ�����(����ѽ��д��ˣ��ʿ��Ԍ�ָ����)
        
        ��nums[i] + nums[j] + nums[k] > 0
        �Ƅ���ָ�k
        
        ��nums[i] + nums[j] + nums[k] < 0
        �Ƅ���ָ�j
        
        */
        
        for(int i = 0; i < nums.length; i ++) {
            //����iָ��Ƶ����}Ԫ��
            if(i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                
                while(j < k) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sub_result = new ArrayList<Integer>();
                        sub_result.add(nums[i]);
                        sub_result.add(nums[j]);
                        sub_result.add(nums[k]);
                        result.add(sub_result);
                        
                        j ++;
                        k --;
                        
                        //����jָ��Ƶ����}Ԫ��
                        while(j < k && nums[j] == nums[j - 1]) {
                            j ++;
                        }
                        //����kָ��Ƶ����}Ԫ��
                        while(j < k && nums[k] == nums[k + 1]) {
                            k --;
                        }
                        
                    } else if(nums[i] + nums[j] + nums[k] > 0) {
                        k --;
                    } else if(nums[i] + nums[j] + nums[k] < 0) {
                        j ++;
                    }
                }
            }
        }
        
        return result;
    }
}
