package src.LeetCode.Easy;

import LeetCode.Dependencies.VersionControl;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    //利用2分搜尋法
    public int firstBadVersion(int n) {     
        int mid = 0;
        int max = n;
        int min = 1;
        
        // 用二分法進行搜尋，減少loop次數
        while(max > min + 1) {
            mid = min + ((max - min) / 2);
            if(isBadVersion(mid) == true) {
                max = mid;
            } else {
                min = mid;
            }
        }
        
        if(isBadVersion(min)) {
            return min;
        }

        
        return max;
    }
}