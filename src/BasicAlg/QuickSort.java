package BasicAlg;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		for(int i = 0; i < arr.length; i ++) {
			System.err.print(arr[i]);
		}
		QuickSort qs = new QuickSort();
		qs.quickSort(arr, 0, arr.length - 1);
		System.err.println("");
		for(int i = 0; i < arr.length; i ++) {
			System.err.print(arr[i]);
		}
	}
	
	void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if(left < index - 1)
			quickSort(arr, left, index - 1);
		if(index < right)
			quickSort(arr, index, right);
	}
	
	int partition(int[] arr, int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		
		while(i <= j) {
			while(arr[i] < pivot)
				i ++;
			while(arr[j] > pivot)
				j --;
			if(i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i ++;
				j --;
			}
		}
		
		return i;
	}
}
