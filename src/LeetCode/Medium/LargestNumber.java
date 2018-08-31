package src.LeetCode.Medium;
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
        
        //先按照特定規則排序
        Collections.sort(res, new Comparator<Integer>() {
        	//按照兩個數字串接起來誰大的規則來排序
            //例如:3, 34 => 334, 343
            public int compare(Integer o1, Integer o2) {
                String leftRight = "" + o1 + o2; //第一個數字前，第二個數字後
                String rightLeft = "" + o2 + o1; //第二個數字前，第一個數字後
                
                //compareTo�������ֵ���������ִ�
                return rightLeft.compareTo(leftRight);
            }
        });
        
        //開始組合數字
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.size(); i ++) {
            sb.append(res.get(i));
        }
        
        //把組合後的數字前面的0去掉
        while(sb.charAt(0) == '0' && sb.length() > 1) {
        	sb.deleteCharAt(0);
        }
        
        //輸出結果
        return sb.toString();
    }
}