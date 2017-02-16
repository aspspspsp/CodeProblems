package Easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null)
            return 0;
        
        int length = nums.length;
        if(target > nums[length - 1])
            return length;
        
        //���ö��ֲ��ҷ���Ҫ�����λ��
        int left = 0;
        int right = length;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(target > nums[mid])
                left = mid + 1;
            else if(target < nums[mid])
                right = mid - 1;
            else
                return mid;
        }
        
        return left;
    }
}