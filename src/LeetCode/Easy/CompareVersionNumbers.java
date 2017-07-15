package LeetCode.Easy;

import java.util.ArrayList;
/*
 * 题意：比较版本号大小
 * 解决思路：比较小数点前数字，再比较后
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> vers1 = getVers(version1);
        ArrayList<Integer> vers2 = getVers(version2);
        
        //得到文字長度最短的版本號
        int shorest_ver_size = Math.min(vers1.size(), vers2.size());
        
        //開始比較版本號，並比較至最短版本號的結尾
        for(int i = 0; i < shorest_ver_size; i ++) {
            int sub_ver1 = vers1.get(i);
            int sub_ver2 = vers2.get(i);
            
            if(sub_ver1 > sub_ver2)
                return 1;
            else if(sub_ver2 > sub_ver1)
                return -1;
        }
        
        //若兩個版本號的公共部分，若都一樣，則比較版本號的長度大小，若長度一樣則兩個版本號一致
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
    
    /**
     * @param version :版本號
     * @return 切割後的子版本號
     */
    ArrayList<Integer> getVers(String version) {
        ArrayList<Integer> vers = new ArrayList<Integer>();
        
        //版本號是以"."來進行切割，然後會把它們都存放入vers這個ArrayList裡面
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