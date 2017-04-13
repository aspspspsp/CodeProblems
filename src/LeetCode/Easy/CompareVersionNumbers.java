package LeetCode.Easy;

import java.util.ArrayList;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> vers1 = getVers(version1);
        ArrayList<Integer> vers2 = getVers(version2);
        
        //ȡ��С�Ӱ�̖���L��
        int shorest_ver_size = Math.min(vers1.size(), vers2.size());
        
        //����ͬ�L�Ȳ��ֵ��Ӱ汾̖�M�б��^
        for(int i = 0; i < shorest_ver_size; i ++) {
            int sub_ver1 = vers1.get(i);
            int sub_ver2 = vers2.get(i);
            
            if(sub_ver1 > sub_ver2)
                return 1;
            else if(sub_ver2 > sub_ver1)
                return -1;
        }
        
        //��ɂ��汾̖�L�Ȳ�һ�£��t���^�L���^�L�İ汾̖�Ƿ���^��
        //ex1:1
        //ex2:1.0.1
        if(vers1.size() > vers2.size()) {
            for(int i = shorest_ver_size; i < vers1.size(); i ++) {
                if(vers1.get(i) > 0) 
                    return 1;
            }
            return 0;
        }
            
        else if(vers2.size() > vers1.size()) {
            for(int i = shorest_ver_size; i < vers2.size(); i ++) {
                if(vers2.get(i) > 0)
                    return -1;
            }
            return 0;
        }
        
        return 0;
    }
    
    ArrayList<Integer> getVers(String version) {
        ArrayList<Integer> vers = new ArrayList<Integer>();
        
        //�汾̖���c�з֣��@�eҪע��
        String[] ver_s = version.split("\\.");
        
        if(ver_s.length == 0) {
        	int ver = Integer.parseInt(version); 

        	vers.add(ver);
        }
        
        for(int i = 0; i < ver_s.length; i ++) {
            int ver = Integer.parseInt(ver_s[i]);
            vers.add(ver);
        }
        
        return vers;
    }
}