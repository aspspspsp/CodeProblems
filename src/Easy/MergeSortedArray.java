package Easy;
/*
nums1和nums2都已经是排好序的数组，我们只需要从后往前比较就可以了。

因为nums1有足够的空间容纳nums1 + nums2，我们使用游标指向m + n - 1
，也就是最大数值存放的地方，从后往前遍历nums1，nums2，谁大就放到
m + n - 1这里，nums1>nums2递减m，nums1<nums2递减n。
*/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m --;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n --;
            }
        }
        
        while(n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n --;
        }
    
    }
}