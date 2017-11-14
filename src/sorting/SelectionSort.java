package sorting;

public class SelectionSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		ss(arr);
	}
	public static <T extends Comparable<T>> void ss(T[] arr) {
		for (int b = 0; b < arr.length; b++) {
			int small = b;
			for (int i = b; i < arr.length; i++) {
				if (arr[small].compareTo(arr[i]) > 0) {
					small = i;
				}
			}
			swap(arr, b, small);
		}
	}
	
	private static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"w", "a", "c", "d", "aq", "gz", "zaa", "aa"};
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
    	
    	SelectionSort.sort(arr);
    	
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
	}
}
