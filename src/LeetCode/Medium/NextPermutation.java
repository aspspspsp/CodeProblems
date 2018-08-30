package src.LeetCode.Medium;

public class NextPermutation {
    /* 以下步驟可以解決這一題:
    1.從右向左掃描，找到第一個比上一個小(比左邊小)的元素，指針為p，如:
      4 5 6 3 2 1
        |
        p
        
    2.從右向左掃描，找到第一個比p大的元素，指針為q，如:
      4 5 6 3 2 1
          |
          q
         
    3.交換p與q，如:
      4 5 6 3 2 1
      交換後:
      4 6 5 3 2 1
      
    4.將數組元素p + 1~ nums.length逆轉
      4 6 1 2 3 5
    */
    public void nextPermutation(int[] nums) {
        if(nums.length < 2 || nums == null) {
            return;
        }
        
        int p = 0;
        for(int i = nums.length - 2; i >= 0; i --) {
            if(nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        
        int q = 0;
        for(int i = nums.length - 1; i > p; i --) {
            if(nums[i] > nums[p]) {
                q = i;
                break;
            }
        }
        
        if(p == 0 && q == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        swap(nums, p, q);
        
        if(p < nums.length - 1) {
            reverse(nums, p + 1, nums.length - 1);
        }
    }
    
    void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left ++;
            right --;
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
