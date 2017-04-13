package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempIP = new ArrayList<>();
        
        dfs(result, tempIP, s, 0);
        
        //���^�K�M��IP
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
    
    //tempIP����IP�ȵĔ��֣���4���^�K
    void dfs(List<List<String>> result, List<String> tempIP, String s, int start) {
        //�����r��IP��ַ�^�K>4,ex:123.123.123.123.123,�t����
        if(tempIP.size() > 4) 
            return;
            
        //�_�Jtemp�Ĵ�С�cʣ�µ��ִ�Ҫ���>=4����t����
        if(tempIP.size() + s.length() - start + 1 < 4)
            return;
        
        //���a��IP��(�v����)���t���Y������
        if(tempIP.size() == 4 && start == s.length()) {
            List<String> t = new ArrayList<>(tempIP);
            result.add(t);
            return;
        }
        
        //һ��ip�^�K���ֻ��3������0~255
        for(int i = 1; i <= 3; i ++) {
            //�_�J�ִ��ڹ�����
            if(i + start > s.length())
                break;
            
            String sub = s.substring(start, start + i);
            //̎����001֮�case�����L��>1(�����^0.0.0.0֮���r)�����ַ���0�t���^
            if(i > 1 && s.charAt(start) == '0') 
                break;
                
            //̎����255֮�case�����˅^�K>255�t���^
            if(Integer.valueOf(sub) > 255)
                break;
            
            //���땺��
            tempIP.add(sub);
            
            //�M����һ݆dfs
            dfs(result, tempIP, s, start + i);
            
            //�hȥ����һ���Y�����M��3�����ֵĚv��
            tempIP.remove(tempIP.size() - 1);
        }
    }
}