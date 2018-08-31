package src.LeetCode.Algorithms.Easy;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int numOfA = 0;        
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i ++) {
            //檢查是否有三個A
            if(chars[i] == 'A') {
                numOfA ++;
                if(numOfA > 1)
                    return false;
            //檢查是否連續有兩個L
            } else if(chars[i] == 'L') {                
                int j = 0;
                for(j = 0; j < 3 && i + j < chars.length; j ++) {
                    if(chars[i + j] != 'L')
                        break;
                }
                
                if(j >= 3)
                    return false;
            }
        }
        
        return true;
    }
}