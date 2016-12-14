package Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempIP = new ArrayList<>();
        
        dfs(result, tempIP, s, 0);
        
        //將區塊組成IP
        List<String> finalResult = new ArrayList<>();
        for(List<String> res : result) {
            StringBuilder sb = new StringBuilder();
            for(String str : res) {
                sb.append(str + ".");
            }
            sb.setLength(sb.length() - 1);
            finalResult.add(sb.toString());
        }
        
        return finalResult;
    }
    
    //tempIP暫存IP內的數字，分4個區塊
    void dfs(List<List<String>> result, List<String> tempIP, String s, int start) {
        //若暫時的IP地址區塊>4,ex:123.123.123.123.123,則跳出
        if(tempIP.size() > 4) 
            return;
            
        //確認temp的大小與剩下的字串要大於>=4，否則跳出
        if(tempIP.size() + s.length() - start + 1 < 4)
            return;
        
        //若產生IP完(歷遍完)，則將結果加入
        if(tempIP.size() == 4 && start == s.length()) {
            List<String> t = new ArrayList<>(tempIP);
            result.add(t);
            return;
        }
        
        //一個ip區塊最多只有3個數字0~255
        for(int i = 1; i <= 3; i ++) {
            //確認字串在範圍內
            if(i + start > s.length())
                break;
            
            String sub = s.substring(start, start + i);
            //處理如001之類的case，若長度>1(避略過0.0.0.0之類的情況)且首字符為0則略過
            if(i > 1 && s.charAt(start) == '0') 
                break;
                
            //處理如255之類的case，若此區塊>255則略過
            if(Integer.valueOf(sub) > 255)
                break;
            
            //加入暫存
            tempIP.add(sub);
            
            //進行下一輪dfs
            dfs(result, tempIP, s, start + i);
            
            //刪去最後一個結果以進行3個數字的歷遍
            tempIP.remove(tempIP.size() - 1);
        }
    }
}