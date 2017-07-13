package LeetCode.Medium;
/*
A[0] = 0. Case 1. There are no active lists, create one.
0.
-----------------------------------------------------------------------------
A[1] = 8. Case 2. Clone and extend.
0.
0, 8.
-----------------------------------------------------------------------------
A[2] = 4. Case 3. Clone, extend and discard.
0.
0, 4.
0, 8. Discarded
-----------------------------------------------------------------------------
A[3] = 12. Case 2. Clone and extend.
0.
0, 4.
0, 4, 12.
-----------------------------------------------------------------------------
A[4] = 2. Case 3. Clone, extend and discard.
0.
0, 2.
0, 4. Discarded.
0, 4, 12.
-----------------------------------------------------------------------------
A[5] = 10. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 10.
0, 4, 12. Discarded.
-----------------------------------------------------------------------------
A[6] = 6. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 6.
0, 2, 10. Discarded.
-----------------------------------------------------------------------------
A[7] = 14. Case 2. Clone and extend.
0.
0, 2.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[8] = 1. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2. Discarded.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[9] = 9. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2, 6.
0, 2, 6, 9.
0, 2, 6, 14. Discarded.
-----------------------------------------------------------------------------
A[10] = 5. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 5.
0, 2, 6. Discarded.
0, 2, 6, 9.
-----------------------------------------------------------------------------
A[11] = 13. Case 2. Clone and extend.
0.
0, 1.
0, 1, 5.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[12] = 3. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 5. Discarded.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[13] = 11. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 2, 6, 9.
0, 2, 6, 9, 11.
0, 2, 6, 9, 13. Discarded.
-----------------------------------------------------------------------------
A[14] = 7. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9. Discarded.
0, 2, 6, 9, 11.
----------------------------------------------------------------------------
A[15] = 15. Case 2. Clone and extend.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9, 11.
0, 2, 6, 9, 11, 15. <-- LIS List
----------------------------------------------------------------------------

case 1. If A[i] is smallest among all end 
   candidates of active lists, we will start 
   new active list of length 1.
case 2. If A[i] is largest among all end candidates of 
  active lists, we will clone the largest active 
  list, and extend it by A[i].

case 3. If A[i] is in between, we will find a list with 
  largest end element that is smaller than A[i]. 
  Clone and extend this list by A[i]. We will discard all
  other lists of same length as that of this modified list.
*
*
*
*/
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int len = 0; //紀錄目前tailTable數組的中止點(Ex:12345 len = 2)
		             //                          -  代表到3為止ֹ
		int size = nums.length;
		
		if(size == 0)
		    return len;
		
		//若新加入的元素(nums[i])最小
		int tailTable[] = new int [size];
		
		tailTable[0] = nums[0];
		len = 1;
		for(int i = 1; i < size; i ++) {
			if(nums[i] < tailTable[0]) {
				//則將最新加入的元素放到最前面 case 1
				
				//則將最新加入的元素放到最前面
				tailTable[0] = nums[i];
			} else if(nums[i] > tailTable[len - 1]) {
				//若新加入的元素(nums[i])最大 case 2
				
				//最大的元素為tailTable的最後一個元素
				tailTable[len] = nums[i];
				
				//則延展tailTable
				len = len + 1; //將中止點往後一位
			} else {
				//其他情況(新加入的元素在最大值與最小值之間) case 3
				
				//��tailTable�ҵ��˔�������λ�ÁKӛ���
				tailTable[ceilIndex(tailTable, -1, len - 1, nums[i])] = nums[i];
			}
		}
		
		return len;
	}
	
	//返回不小於key最小整數值的index
	int ceilIndex(int[] tailTable, int left, int right, int key) {
		//二分搜尋法
		while(right - left > 1) {
			//若搜尋範圍能大於1(右邊-左邊會大於1)
			
			//找到中點
			int mid = left + ((right - left) / 2);
			
			if(tailTable[mid] >= key) {
				//元素在中點的右邊
				
				right = mid;
			} else {
				//元素在中點的左邊
				
				left = mid;
			}
		}
		return right;
	}
}