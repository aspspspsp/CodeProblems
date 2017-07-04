package LeetCode.Easy;
import LeetCode.Dependencies.VersionControl;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    //����2���ь���
    public int firstBadVersion(int n) {     
        int mid = 0;
        int max = n;
        int min = 1;
        
        // �ö��ַ��M���ь����p��loop�Δ�
        while(max > min + 1) {
            mid = min + ((max - min) / 2);
            if(isBadVersion(mid) == true) {
                max = mid;
            } else {
                min = mid;
            }
        }
        
        //����һ���汾�����e�ģ�����İ汾�����e��
        if(isBadVersion(min)) {
            return min;
        }

        return max;
    }
}