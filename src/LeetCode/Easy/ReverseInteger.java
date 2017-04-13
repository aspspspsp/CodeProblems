package LeetCode.Easy;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegivate = false;
        int startAt = 0;
        String ans = "";
        
        if(x < 0) {
            isNegivate = true;
            startAt = 1;
        } else if(x == 0) {
            return 0;
        }
        
        String stringX = x + "";
        
        for(int i = startAt; i < stringX.length(); i ++) {
            ans = stringX.substring(i, i + 1) + ans;
        }
        
        if(isNegivate == true) {
            ans = "-" + ans;
        }
        
        //����Ҫ���Ƿ�ֹ������@�e��������ֹ�����̎��
        long tmp = Long.parseLong(ans);
        if(tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE)
        {
            return 0;
        }
        
        //���ش�
        return Integer.parseInt(ans);
    }
}