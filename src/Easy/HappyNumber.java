package Easy;

import java.util.LinkedList;

/*
设计一个算法，判断一个数字是否“快乐”。
快乐数可以被如下流程定义：
一个正整数，计算出它各位数字的平方和，得到一个新的数字，
再对这个新的数字重复这一过程，直到最后得到:
1.数字1
2.其他某几个数字的无限循环(不為快樂數)。
在这些数字中，经过上述流程最终能得到数字1的数字，被称为“快乐数”。
*/
public class HappyNumber {
    public boolean isHappy(int n) {
        int temp = n;
        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(n);
        while(true) {
            temp = getNextNumber(temp);
            if(temp == 1) {
                return true;
            } else if(nums.contains(temp)) {
                return false;
            }
            nums.add(temp);
        }
    }
    
    int getNextNumber(int num) {
        int result = 0;
        while(num > 0) {
            result = result + (num % 10) * (num % 10);
            num = num / 10;
        }
        
        return result;
    }
}