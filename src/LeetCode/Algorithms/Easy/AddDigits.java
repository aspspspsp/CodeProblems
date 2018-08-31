package src.LeetCode.Algorithms.Easy;
/*
 * 
 * 下面是1到20的所有的树根：
 * n    mod
 * ======================================
 * 1     1
 * 2     2
 * 3     3
 * 4     4
 * 5     5
 * 6     6
 * 7     7
 * 8     8
 * 9     9
 * 10    1
 * 11    2
 * 12    3
 * 13    4
 * 14    5
 * 15    6
 * 16    7
 * 17    8
 * 18    9
 * 19    1
 * 20    2
*/
public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}