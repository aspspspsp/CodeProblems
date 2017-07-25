package LeetCode.Medium;
/*
思路
跟快速排序一个思路。先取一个枢纽值，将数组中小于枢纽值的放在左边，大于
枢纽值的放在右边，具体方法:
用左右两个指针，如果他们小于枢纽值则将他们换到对面
一轮过后记得将枢纽值赋回分界点。
如果这个分界点是k，说明分界点的数就是第k个数。
否则，如果分界点大于k，则在左半边做同样的搜索。
如果分界点小于k，则在右半边做同样的搜索。

注意
helper函数的k是k-1，因为我们下标从0开始的，我们要比较k和下标，来确定是
否左半部分有k个数字。
互换左右时，也要先判断left <= right
 */
public class KthLargestElementInAnArray_On {
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, k - 1, 0, nums.length - 1);
	}

	private int quickSelect(int[] arr, int k, int left, int right) {
		int pivot = arr[(left + right) / 2];
		int orgL = left, orgR = right;
		while (left <= right) {
			// 从右向左找到第一个小于枢纽值的数
			while (arr[left] > pivot) {
				left++;
			}
			// 从左向右找到第一个大于枢纽值的数
			while (arr[right] < pivot) {
				right--;
			}
			// 将两个数互换
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		// 最后退出的情况应该是右指针在左指针左边一格
		// 这时如果右指针还大于等于k，说明kth在左半边
		if (orgL < right && k <= right)
			return quickSelect(arr, k, orgL, right);
		// 这时如果左指针还小于等于k，说明kth在右半边
		if (left < orgR && k >= left)
			return quickSelect(arr, k, left, orgR);
		return arr[k];

	}

	private void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1] + arr[idx2];
		arr[idx1] = tmp - arr[idx1];
		arr[idx2] = tmp - arr[idx2];

	}
}
