package Interview.BasicAlg;

public class FindK {
	public static void main(String[] args) {
		int[] arr = {3,2,1,4,5};
		int num = quickSelect(arr, 0, arr.length - 1, 1);
		System.err.println(num);
	}
	
	static int quickSelect(int[] arr, int left, int right, int k) {
		if(left == right)
			return arr[left];
	
		int index = partition(arr, left, right);
		
		int cur = index - right + 1;
		if(cur == k)
			return arr[index];
		else if(k < cur)
			return quickSelect(arr, left, index - 1, k);
		else
			return quickSelect(arr, index - 1, right, k);
	}
	
	static int partition(int[] arr, int left, int right) {
		int i = left, j = right;
		int pivot = arr[(left + right) / 2];
		
		while(i <= j) {
			while(arr[i] < pivot)
				i ++;
			while(arr[j] > pivot)
				j --;
			
			if(i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i ++;
				j --;
			}
		}
		
		return i;
	}
}
