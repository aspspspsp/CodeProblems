package LeetCode.Hard;

public class LongestValidParentheses {
  public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        int count = 0;
        
        //這個棧是紀錄當前的位置有多少個(
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i ++) {
            if(s.charAt(i) == '(') {
                stk.push(count);
                count = 0;
            } else if(stk.isEmpty() == false) {
                count = count + 1 + stk.pop();
                res = Math.max(res, count);
            //遇到非法的情況 ex: ())
            } else {
                count = 0;
            }
            
        }
        return res * 2;
    }
}
