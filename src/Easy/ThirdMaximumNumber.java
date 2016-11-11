package Easy;
/*
如果知道怎么求第二大的数，那么求第三大的数的思路都是一样的。
那么我们用三个变量
first, second,third来分别保存第一大，第二大，和第三大的数
然后我们遍历数组，如果遍历到的数字大于当前第一大的数first
那么三个变量各自错位赋值，如果当前数字大于second，小于first
那么就更新second和third，如果当前数字大于third，小于second那就只更新third
注意这里有个坑，就是初始化要用长整型long的最小值，否则当数组中有MIN_VALUE
存在时，程序就不知道该返回MIN_VALUE还是最大值first了
*/
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if(nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if(nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }
        
        if(second == Long.MIN_VALUE || third == Long.MIN_VALUE)
            return (int)first;
        return (int)third;
    }
}