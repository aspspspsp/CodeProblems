/*
	使用2分法快速求出冪
为了减少时间的消耗，我们可以使用二分法。

举个例子：求2的8次幂。

设结果为result

result = 2^8
设result1 = 2^4，很容易推出 result=result1*result1
设result2 = 2^2，同理，result1 = result2*result2
...

再举个例子,result3 = 2^7
那么 result3 = result1 * 2^3
2^3 = 2^2 *2^1
*/
public class Solution {
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