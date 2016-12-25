package Easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> n1_list = new ArrayList<>();
        List<Integer> intersect = new ArrayList<>();
        
        for(int num:nums1) {
            n1_list.add(num);
        }
        
        //因為元素已經排好序(且答案不考慮順序)，所以不用考慮像是[1, 2, 2, 1]的狀況
        for(int i = 0; i < nums2.length; i ++) {
            if(n1_list.contains(nums2[i])) {
                //加入相交集
                intersect.add(nums2[i]);
                //把已經加入相交集的元素去掉
                n1_list.remove(n1_list.indexOf(nums2[i]));
            }
        }
        
        //將答案輸出為數組
        int [] answer = new int[intersect.size()];
        for(int i = 0; i < intersect.size(); i ++) {
            answer[i] = intersect.get(i);
        }
        return answer;
    }
}