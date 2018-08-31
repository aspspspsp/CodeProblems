package src.LeetCode.Algorithms.Medium;
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int [] result = {-1, -1};
        // start index, end index
        
        int maxIndex = nums.length - 1;
        
        //找最左的index
        int leftmostIndex = findLeftmostIndex(nums, 0, maxIndex, target);
        //找最右的index
        int rightmostIndex = findRightmostIndex(nums, 0, maxIndex, target);
        
        //̎處理找不到該數的情況
        //因為 leftIndex與rightIndex有可能不是指向目標數(找不到的情況)，故在這裡要進行檢查
        if(leftmostIndex >  nums.length - 1 || nums[leftmostIndex] != target) {
            return result;
        }
        
        result[0] = leftmostIndex;
        result[1] = rightmostIndex;
        
        return result;
    }   
    
    //二分查找法，找到最左邊的數的index
    int findLeftmostIndex(int [] nums, int leftIndex, int rightIndex, int target) {
        while(leftIndex <= rightIndex) {
            //計算中位數
            int midIndex = (leftIndex + rightIndex) / 2;
            
            //優先找左邊的數
            if(nums[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        
        return leftIndex;
    }
    
    //二分查找法，找到最右邊的數的index
    int findRightmostIndex(int [] nums, int leftIndex, int rightIndex, int target) {
        while(leftIndex <= rightIndex) {
            //計算中位數
            int midIndex = (leftIndex + rightIndex) / 2;
            
            //優先找右邊的數
            if(nums[midIndex] > target) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        
        return rightIndex;
    }
}