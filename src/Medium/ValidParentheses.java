package Medium;

import java.util.HashMap;
import java.util.Stack;

/*
 ex:[()][]
    opt     stack 解釋
 1.push [ =>  [
 2.push ( =>  [(  
 3.pop  ( =>  [   因為遇到) 故要排出(
 4.check ()
 5.pop  [ =>      因為遇到] 故要排出[
 6.check []
 7.push [ =>  [
 8.pop  [ =>      因為遇到] 故要排出[
 9.check []
*/
public class ValidParentheses {
    HashMap<String, String> parentheses = new HashMap<String, String>();
    
    Stack<String> stack = new Stack<String>();
    public boolean isValid(String s) {
        
        //灏嶆暣鍊婼tring閫愭妾㈡煡
        for(int i = 0; i < s.length(); i ++) {
            String token = s.substring(i, i + 1);
            
            // 濡傛灉閬囧埌鍓嶆嫭鍙�(Ex: "(", "[", "{")灏卞帇鍏ユ爤  
            if(token.equals("(") || token.equals("[") || token.equals("{")) {
                stack.push(token);
            
            // 濡傛灉閬囧埌寰屾嫭鍙�(Ex: ")", "]", "]")灏辨帓鍑烘爤
            } else if(token.equals(")") || token.equals("]") || token.equals("}")) {
                
                //鑻tack鐐虹┖锛岃〃绀哄乏鍙虫嫭铏熶甫涓嶅潎绛夛紝鏁呯偤false
                if(stack.isEmpty() == true)
                    return false;
                
                if(stack.isEmpty() == false) {
                    //鍙帓鍑轰竴鍊嬫嫭鍙�
                    String check = stack.pop();
                    
                    //鑻�(,)鍓囬�欏�嬫槸姝ｇ⒑鐨�
                    if(check.equals("(") == true && token.equals(")") == true)
                        continue;
                    //鑻,]鍓囬�欏�嬫槸姝ｇ⒑鐨� 
                    else if(check.equals("[") == true && token.equals("]") == true)
                        continue;
                    //鑻,}鍓囬�欏�嬫槸姝ｇ⒑鐨�
                    else if(check.equals("{") == true && token.equals("}") == true)
                        continue;
                    //閮戒笉鏄〃绀烘嫭铏熷尮閰嶉尟瑾�
                    else
                        return false;
                }
            }
        }
        
        //鍥犵偤鎷櫉閮芥槸鍏╁叐鐩稿皪鐨勶紝鑻ラ倓鏈夊墿椁樼殑瑭辫〃绀哄乏鍙虫嫭铏熶甫涓嶅潎绛夛紝鍓囩偤false
        if(stack.isEmpty() == true)
            return true;
        else 
            return false;
    }
}