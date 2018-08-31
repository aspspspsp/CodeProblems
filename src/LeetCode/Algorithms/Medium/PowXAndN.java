package src.LeetCode.Algorithms.Medium;

/*
思路:
通过一点点数学推导我们可以知道，如果n是偶数，會是以下情況:
x^n * x^n = x^(2n)
如果n是奇数，會是以下情況:
x^n * x^n * x=x^(2n+1)

根据这几条原则递归，我们就不用将x相乘n次，而只要logN次就行了

注意:
在递归函数中处理n的奇偶问题，在主函数中处理n的正负问题
*/
public class PowXAndN {
    public double myPow(double x, int n) {
        if(n < 0){
            // n为负返回倒数
            return 1 / pow(x, -n);
        } else {
            // n为正直接返回结果
            return pow(x, n);
        }
    }

    private double pow(double x, int n){
        // 递归终止条件
        if(n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }
        double val = pow(x, n/2);
        // 根据奇数还是偶数返回不同的值
        if(n % 2 == 0){
            return val * val;
        } else {
            return val * val * x;
        }
    }
}