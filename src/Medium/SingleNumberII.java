package Medium;

public class SingleNumberII {
    /*
    给一个数组，里面只有一个数字一次，其它数字都出现3次，找出这个出现一次的数字，
    要求时间复杂度为O(n)，空间复杂度为O(1)。最好不傅额外的空间。 
    利用位运算来消除重复3次的数。
    
    以一个数组[14 14 14 9]为例，将每个数字以二进制表达：
    1110     14
    1110     14
    1110     14
    1001     9
    +______  
    4331 (对上面的每一位进行求和)
    _______
    1001 (再对上面的和(4331)的每一位做%3运算，来消去所有重复3次的数)
    */
    public int singleNumber(int[] nums) {
        //用大小为 32的数组来记录所有位上的和。 
        int [] count = new int[32]; 
        int result = 0;
        
        // 對所有位(count)的每一位進行運算
        for(int i = 0; i < 32; i ++) {
            // 加總所有數組
            for(int n : nums) {
                // 统计第i位的1的个数(加總第i位的1)
                if(((n >> i) & 1) == 1) {
                    count[i] ++;
                }
            }
            // 对count的每一位每一位做%3运算
            result = result | count[i] % 3 << i;
        }
        
        return result;
       
    }
}