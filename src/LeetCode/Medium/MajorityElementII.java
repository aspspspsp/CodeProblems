package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*
找出数组中所有出现次数超过总数1/3的元素。
这类问题有一个很经典的算法叫做BM多数投票算法（Boyer-Moore Majority Vote algorithm），时间复杂度O(n)，空间复杂度O(1)。
大体思路就是使用一个变量来计数当前出现次数最多的元素X。如果你发现了一个不等于X的数Y，那么计数变量减一。
例如，如果数组中有5个X和4个Y，那么可以说X比Y多（5-4）个，或者说有4个X被Y抵消了。
想进一步了解该算法的话，请参考http://goo.gl/64Nams。
对于这道题，我们要找到是出现次数大于总数1/3的数，符合要求的数可以能有0个、1个、2个。
我们可以在BM多数投票算法的基础上稍作改动，使用2个计数变量即可。
其他原理是一样的。需要注意的是，在一轮“抵消”的过程结束后，我们只能保证此时得到的这2个元素是数量最多的，但不见得就超过了总数的1/3。
因此，我们还要再分别对这两个数进行一次计数，看它们出现的次数是不是超过了1/3。
*/

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        
        //�ҵ�ǰ�ɂ����Ĕ�
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for(int num : nums) {
            //��������������е�һ���������ļ�������1
            if(candidate1 == num) {
                count1 ++;
            //��������������е�һ���������ļ�������1
            } else if(candidate2 == num) {
                count2 ++;
            //���������Ϊ0�ˣ���ͳ�Ƶ�ǰ���������
            } else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            //���������Ϊ0�ˣ���ͳ�Ƶ�ǰ���������
            } else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            //����������������е��κ�һ���������������1
            } else {
                count1 --;
                count2 --;
            }
        }
        
        //�����x�ăɂ�����count��Ӌ��һ��(��C���ִ����Ƿ񳬹�1/3)
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