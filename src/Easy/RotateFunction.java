package Easy;
/*
动态规划法。
为了降低时间复杂度，我们需要想点其他的方法，对比给出的示例:
F(0)与F(1)的区别，就是
F(0)中除了A[i-1]之外，其他的数字都增加了一倍，并且还要再减去(i-1)*A[i-1]
F(1)就是增加了4，3，2，然后再减去了36，F(1)=F(0)+4+3+2-36=16。
因此我们可以求出这样一个公式：
F(i)=F(i-1)+(sum-A[sumIndex])-(A.length-1)*A[sumIndex]，其中
sumIndex=-i+A.length
即旋转时要从索引i-1移动到0的那个值。
sum为数组A中所有值的和，
而(sum - A[sumIndex]) 自然就是数组A中除了索引为sumIndex之外其他所有值的和。
这种解法的时间复杂度是O(n)。
*/

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        // 计算出sum
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
    
        int base = 0;
        // 计算出F(0)的值
        for (int i = 0; i < A.length; i++) {
            base += i * A[i];
        }
    
        int max = base;
        for (int i = 1; i < A.length; i++) {
            int sumIndex = A.length - i;
            // 公式展开后，得出如下
            base += sum - A.length * A[sumIndex];   // base += (sum - A[sumIndex]) - (A.length - 1) * A[sumIndex]; 
            max = Math.max(max, base);
        }
        return max;
    }
}