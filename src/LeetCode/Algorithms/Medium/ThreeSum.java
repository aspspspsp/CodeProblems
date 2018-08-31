package src.LeetCode.Algorithms.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //先將數組進行排序(以方便進行夾逼)
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        /*
        i 進行循序歷遍
        j 由i進行向右夾逼
        k 由數組最後一個進行向左夾逼
        
                若nums[i] + nums[j] + nums[k] == 0
                則加入該結果
                並且讓i與j指針更靠近(因為已經有答案了，故可以將指針向內)
        
                若nums[i] + nums[j] + nums[k] > 0
                移動右指針k
        
                若nums[i] + nums[j] + nums[k] < 0
                移動左指針j
        
        */
        
        for(int i = 0; i < nums.length; i ++) {
            //避免i重複的情形
            if(i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                
                //進行左右指針夾逼的動作
                /*     i j     k
                 * ex: 1 2 3 4 5
                 *  => i   j k
                 */
                while(j < k) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sub_result = new ArrayList<Integer>();
                        sub_result.add(nums[i]);
                        sub_result.add(nums[j]);
                        sub_result.add(nums[k]);
                        result.add(sub_result);
                        
                        //做完之後一定要移動指針(表示做過了)
                        j ++;
                        k --;
                        
                        //避免指針移到重複元素，並確保j < k避免指針錯誤
                        while(j < k && nums[j] == nums[j - 1]) {
                            j ++;
                        }
                        //避免指針移到重複元素，並確保j < k避免指針錯誤
                        while(j < k && nums[k] == nums[k + 1]) {
                            k --;
                        }
                    //移動右指針k
                    } else if(nums[i] + nums[j] + nums[k] > 0) {
                        k --;
                    //移動右指針j
                    } else if(nums[i] + nums[j] + nums[k] < 0) {
                        j ++;
                    }
                }
            }
        }
        
        return result;
    }
}
