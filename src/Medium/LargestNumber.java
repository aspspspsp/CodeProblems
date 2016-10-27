package Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
本題可以應用貪心法
贪心思路：对于两个备选数字a和b，如果str(a) + str(b) > str(b) + str(a)，则a在b之前，否则b在a之前
                               ex: "3" + "21" > "12" + "3"
按照此原则对原数组从大到小排序即可
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
            //這裡一定要用string 直接做排序，不使用Integer轉型，因為速度會太慢
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                
                //compareTo會按照字典序來排序字串
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