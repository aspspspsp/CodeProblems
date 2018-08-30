package src.LeetCode.Medium;

public class HIndexII {
    /*
    第275题的内容与第274题基本一致，只是多提供了一个条件：
    传入的数组是升序排列的。这道题仍然可以使用上面的方法计算H指数，不过可以省略对数组进行手工排序的步骤。
    */
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
            return 0;
        
        int result = 0;
        for(int i = citations.length - 1; i >= 0 ; i --) {
            if(result >= citations[i])
                break;
            result ++;
        }
        
        return result;
    }
}