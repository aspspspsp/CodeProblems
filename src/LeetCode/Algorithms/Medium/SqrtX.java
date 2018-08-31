package src.LeetCode.Algorithms.Medium;
/*
1. System.out.println(sqrt(90));
star    end
1       45
1       23
1       12
6       12
9       12
9       10
9

2. System.out.println(sqrt(20));
star    end
1       10
1        5
3        5
4        5
4

3. System.out.println(sqrt(3));
star    end
1       2
*/

public class SqrtX {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(mid * mid <= x)
                start = mid;
            else
                end = mid;
        }
        
        if(end * end == x)
            return (int)end;
        else
            return (int)start;
    }
}