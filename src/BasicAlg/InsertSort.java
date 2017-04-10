package BasicAlg;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		for(int i = 0; i < arr.length; i ++) {
			System.err.print(arr[i]);
		}
		InsertSort is = new InsertSort();
		is.insertSort(arr, 0, arr.length);
		System.err.println("");
		for(int i = 0; i < arr.length; i ++) {
			System.err.print(arr[i]);
		}
	}
	
	void insertSort(int[] arr, int left, int right) {
		int temp;
		for(int i = left; i < right; i ++){
			for(int j = i; j > left; j --) {
				if(arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
}
