package LeetCode.Medium;

/*
n=0  f(0) = 2(0,1) 
n=1  f(1) = 10 
(0,1,2,3,4,5,6,7,8,9)

n=2  f(2) = 10 + 9 * 9 = 10 + 81 = 91
9 * 9,��һλ��0�ⶼ���ԣ���9��ѡ�񣬵ڶ�λ0���Ե��ǲ����ǵ�һλ�����֣�Ҳ��9��ѡ��

n=3  f(3) = 10 + 9 * 9 + 9 * 9 * 8 = 91 + 648 = 739
9 * 9 * 8 = f(2) * 8, ����λ��8��ѡ��

n=4  f(4) = 10 + 9 * 9 + 9 * 9 * 8 + 9 * 9 * 8 * 7 = 739 + 4536 = 5275
...
n=10 f(10)= f(9) + 9*(9!) 
... 
f(n) = f(10), when n>10  ��n>10�𰸄t��f(10)��ͬ
11λ���Ժ�϶�������ظ���f(k) = 0 , k >= 11
*/
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        
        //0~0
        if(n == 0)
            return 1;
            
        //1~10
        if(n == 1)
            return 10;
            
        //��n>10�𰸄t��f(10)��ͬ
        n = Math.min(n, 10);
        
        //Ӌ��f(n); n = 2~10
        int ans = 10;
        int base = 9;
        
        for(int i = 1; i < n; i ++) {
            base = base * (10 - i);
            ans = base + ans;
        }
        
        return ans;
    }
}