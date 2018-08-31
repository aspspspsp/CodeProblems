package src.LeetCode.Easy;
/*
 * “汉明距离”，一个较为著名的问题，给定两个整数，求出这两个数字的
 * 二进制中位数不同的个数。比如例子中的1和4，在第0位和第2位数字不
 * 同，因此这个汉明距离就是2。
 * ex:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 解法:
 * 比较两个二进制数字中不一样的数据，其实可以直接将两个数字取异或，
 * 然后再求出异或结果的二进制形式中有多少个1即可。
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int i = x ^ y; //對x與y進行異或
    	int count = 0; //紀錄1的個數
        while(i != 0) {
        	count ++; //對1的個數+1
        	i = (i - 1) & i; //去掉最後面的1
        }
        return count;
    }
}
