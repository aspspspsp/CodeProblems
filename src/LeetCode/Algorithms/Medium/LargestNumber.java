package src.LeetCode.Algorithms.Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
要拼成最大数，我们只要让较大的数排在前面，较小的数排在后面就行。
然而如何对原数组排序呢？当比较一位数时，直接比较大小就行了，但对于多位数呢？

1.从第一位向后比较，如果有一位更大，则该数更大，如9大于15，24大于23。

2.如果某个数的前半部分和另一个数完全相同，则看该数剩下的那部分和另一个数的大小关系，
如2332和23比较时，2332是大于23的，因为32大于23。
不过如果细分各种情况，会弄得非常复杂，这里有个技巧，就是我们把两个数拼在一起，然后再
把这两个数换个顺序再拼在一起，这时候就可以直接比较了。比如2332和23，变成233223和
232332两个数，这时候那个数更大，就说明这个数前半部分的那个数是更大的，这里是2332。
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
        	//按照兩個數字串接起來誰大的規則來排序（字典序）
            //例如:3, 34 => 334, 343
            public int compare(Integer o1, Integer o2) {
                String leftRight = "" + o1 + o2; //第一個數字前，第二個數字後
                String rightLeft = "" + o2 + o1; //第二個數字前，第一個數字後
                
                //a.compareTo(b) 以a大於b的方式排序
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