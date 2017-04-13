package LeetCode.Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
���}���ԑ���؝�ķ�
̰��˼·������������ѡ����a��b�����str(a) + str(b) > str(b) + str(a)����a��b֮ǰ������b��a֮ǰ
                               ex: "3" + "21" > "12" + "3"
���մ�ԭ���ԭ����Ӵ�С���򼴿�
*/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null)
            return null;
            
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i ++) {
            res.add(nums[i]);
        }
        
        Collections.sort(res, new Comparator<Integer>() {
            //�@�eһ��Ҫ��string ֱ�������򣬲�ʹ��Integer�D�ͣ�����ٶȕ�̫��
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                
                //compareTo�������ֵ���������ִ�
                return s2.compareTo(s1);
            }
        });
            
        StringBuilder sb = new StringBuilder();
            
        for(int i = 0; i < res.size(); i ++) {
            sb.append(res.get(i));
        }
        
        if(sb.charAt(0) == '0')
            return "0";
            
            
        return sb.toString();
    }
}