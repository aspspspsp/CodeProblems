package LeetCode.Easy;
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

import LeetCode.Dependencies.GuessGame;

//��1~n����һ������
public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        //��n��0�͛]�б�Ҫ����
        if(guess(n) == 0)
            return n;
        
        //���ö����ь�����
        int left = 1;
        int right = n;
        
        while(left < right) {
            //ȡ�����g
            int mid = left + (right - left) / 2;
            
            //guess�����Д�µ��Ĕ��Ƿ����_(���Ǳ��^�󡢱��^С)
            int t = guess(mid);
            
            //������t=0�t���ش�
            if(t == 0) {
                return mid;
                
            //���µĔ����^��t����߅�_ʼ��
            } else if(t == 1) {
                left = mid;
            
            //���µĔ����^С�t����߅�_ʼ��
            } else {
                right = mid;
            }
        }
        
        //����return ��߅������߅��һ��(�������ֻ��ʣ��һ����left = right)
        return right;
    }
}

