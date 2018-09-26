package src.LeetCode.Algorithms.Easy;
/**
 * 整数型数组中，每个元素均出现两次，除了一个元素例外，如何找出这个元
 * 素？能否设计一个线性时间的算法，且不需要额外的存储空间？
 *
 * 利用XOR运算
 * 因为A XOR A = 0，且XOR运算是可交换的，于是，对于实例：
 * {2,1,4,5,2,4,1}　會有下面步驟：
 * ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
 * (2^1^4^5^2^4^1)
 * =>
 * ((2^2)^(1^1)^(4^4)^(5))
 * =>
 * (0^0^0^5) => 5
 *
 * 就把只出现了一次的元素(其余元素均出现两次)给找出来了
**/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 沒有重複的元素
        int result = 0;

        // 對每個元素都進行XOR
        for(int i = 0; i < nums.length; i ++) {
            result = result ^ nums[i];
        }
        
        return result;
    }
}