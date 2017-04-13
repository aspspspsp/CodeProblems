package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> n1_list = new ArrayList<>();
        List<Integer> intersect = new ArrayList<>();
        
        for(int num:nums1) {
            n1_list.add(num);
        }
        
        //���Ԫ���ѽ��ź���(�Ҵ𰸲����]���)�����Բ��ÿ��]����[1, 2, 2, 1]�Ġ�r
        for(int i = 0; i < nums2.length; i ++) {
            if(n1_list.contains(nums2[i])) {
                //�����ཻ��
                intersect.add(nums2[i]);
                //���ѽ������ཻ����Ԫ��ȥ��
                n1_list.remove(n1_list.indexOf(nums2[i]));
            }
        }
        
        //����ݔ���锵�M
        int [] answer = new int[intersect.size()];
        for(int i = 0; i < intersect.size(); i ++) {
            answer[i] = intersect.get(i);
        }
        return answer;
    }
}