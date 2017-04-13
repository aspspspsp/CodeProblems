package LeetCode.Medium;

/*
	ʹ��2�ַ����������
Ϊ�˼���ʱ������ģ����ǿ���ʹ�ö��ַ���

�ٸ����ӣ���2��8���ݡ�

����Ϊresult

result = 2^8
��result1 = 2^4���������Ƴ� result=result1*result1
��result2 = 2^2��ͬ��result1 = result2*result2
...

�پٸ�����,result3 = 2^7
��ô result3 = result1 * 2^3
2^3 = 2^2 *2^1
*/
public class PowXAndN {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
            
        if(n == 1)
            return x;
            
        if(x == 1)
            return 1;
        
        if(n <= -2147483648 && x >= 1)
            return 0;
            
        double result = 1;
        
        boolean isNegOfN = false;
        
        if(n < 0) {
            isNegOfN = true;
            n = -1 * n;
        }

        int k = n / 2;
        int l = n - k * 2;
        
        double x1 = myPow(x, k);
        double x2 = myPow(x, l);
        
        if(isNegOfN == false) 
            return x1 * x1 * x2;
        else
            return 1 / (x1 * x1 * x2);
    }
}