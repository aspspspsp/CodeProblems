package LeetCode.Medium;
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int [] result = {-1, -1};
        // start index, end index
        
        int maxIndex = nums.length - 1;
        
        //�������index
        int leftmostIndex = findLeftmostIndex(nums, 0, maxIndex, target);
        //�����ҵ�index
        int rightmostIndex = findRightmostIndex(nums, 0, maxIndex, target);
        
        //̎���Ҳ���ԓ������r
        //��� leftIndex�crightIndex�п��ܲ���ָ��Ŀ�˔�(�Ҳ�������r)�������@�eҪ�M�Йz��
        if(leftmostIndex >  nums.length - 1 || nums[leftmostIndex] != target) {
            return result;
        }
        
        result[0] = leftmostIndex;
        result[1] = rightmostIndex;
        
        return result;
    }   
    
    //���ֲ��ҷ����ҵ�����߅�Ĕ���index
    int findLeftmostIndex(int [] nums, int leftIndex, int rightIndex, int target) {
        while(leftIndex <= rightIndex) {
            //Ӌ����λ��
            int midIndex = (leftIndex + rightIndex) / 2;
            
            //��������߅�Ĕ�
            if(nums[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        
        return leftIndex;
    }
    
    //���ֲ��ҷ����ҵ�����߅�Ĕ���index
    int findRightmostIndex(int [] nums, int leftIndex, int rightIndex, int target) {
        while(leftIndex <= rightIndex) {
            //Ӌ����λ��
            int midIndex = (leftIndex + rightIndex) / 2;
            
            //��������߅�Ĕ�
            if(nums[midIndex] > target) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
        }
        
        return rightIndex;
    }
}