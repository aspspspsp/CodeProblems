package Medium;

import java.util.ArrayList;
import java.util.List;

/*
BM投票算法（Boyer-Moore Majority Vote algorithm）
这种算法是设置一个数的计数器，在遍历数组的时候，如果是这个数，
则计算器加一，不是则减一，用来计数超过一半的数非常方便。在这里
我们需要进行改进一下，设置两个计数器，来统计两个数出现的次数。

如果是这两个数中的一个，则他的计算器加1，如果不是这两个数中的
任何一个，则计算器都减1，如果计数器为0了，则统计当前的这个数
。
那么如果一个数出现次数超过1/3，则最后必然出现在统计的数中，但是
我们不能确定现在得到的这两个数出现次数是否超过1/3，因此最后需要
再验证一下。
*/

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        
        //找到前兩個最多的數
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for(int num : nums) {
            //如果是这两个数中的一个，则他的计算器加1
            if(candidate1 == num) {
                count1 ++;
            //如果是这两个数中的一个，则他的计算器加1
            } else if(candidate2 == num) {
                count2 ++;
            //如果计数器为0了，则统计当前的这个数。
            } else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            //如果计数器为0了，则统计当前的这个数。
            } else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            //如果不是这两个数中的任何一个，则计算器都减1
            } else {
                count1 --;
                count2 --;
            }
        }
        
        //將候選的兩個數的count在計算一遍(驗證出现次数是否超过1/3)
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(candidate1 == num) {
                count1 ++;
            } else if(candidate2 == num) {
                count2 ++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if(count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if(count2 > nums.length / 3) {
            result.add(candidate2);
        }
        
        return result;
    }
}