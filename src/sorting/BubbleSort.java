package sorting;

public class BubbleSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		bs(arr, arr.length);
	}
	
	public static <T extends Comparable<T>> void bs(T[] arr, int len) {
		T temp;
		for (int l = len; l > 0; l--) {
			for (int i = 0; i < l; i++) {
				if (i < l-1) {
					if (arr[i].compareTo(arr[i+1]) > 0) {
						temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] arr = {"w", "a", "c", "d", "aq", "gz", "zaa", "aa"};
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
    	
    	BubbleSort.sort(arr);
    	
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
	}
	
}
