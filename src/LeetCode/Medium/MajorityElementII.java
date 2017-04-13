package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*
BMͶƱ�㷨��Boyer-Moore Majority Vote algorithm��
�����㷨������һ�����ļ��������ڱ��������ʱ��������������
���������һ���������һ��������������һ������ǳ����㡣������
������Ҫ���иĽ�һ�£�������������������ͳ�����������ֵĴ�����

��������������е�һ���������ļ�������1������������������е�
�κ�һ���������������1�����������Ϊ0�ˣ���ͳ�Ƶ�ǰ�������
��
��ô���һ�������ִ�������1/3��������Ȼ������ͳ�Ƶ����У�����
���ǲ���ȷ�����ڵõ��������������ִ����Ƿ񳬹�1/3����������Ҫ
����֤һ�¡�
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