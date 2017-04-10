package BasicAlg;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		for(int i = 0; i < arr.length; i ++) {
			System.err.print(arr[i]);
		}
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr, 0, arr.length);
		System.err.println("");
		for(int i = 0; i < arr.length; i ++) {
			System.err.print(arr[i]);
		}
	}
	
	void selectionSort(int[] arr, int left, int right) {
		for(int i = left; i < right; i ++) {
			int min = i;
			for(int j = i + 1; j < right; j ++) {
				if(arr[j] < arr[min])
					min = j;
			}
			
			if(i != min) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
}
