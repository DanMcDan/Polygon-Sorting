package sorting;

public class MergeSort {
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
		int n1 = m-l+1,
			n2 = r-m;
		
		
		Object[] left = new Object[n1];
		Object[] right = new Object[n2];
		
		for (int i = 0; i < left.length; i++)
			left[i] = arr[l+i];
		
		for (int i = 0; i < right.length; i++)
			right[i] = arr[m + 1 + i];
		
		int i = 0,
			j = 0;
		
		int k = l;
		while (i < n1 && j < n2) {
			if (((T)left[i]).compareTo((T)right[j]) < 0) {
				arr[k] = (T)left[i];
				i++;
			} else {
				arr[k] = (T)right[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = (T)left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = (T)right[j];
			j++;
			k++;
		}
	}
	
	private static <T extends Comparable<T>> void ms(T[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			
			ms(arr, l, m);
			ms(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	public static <T extends Comparable<T>> void sort(T[] arr) {
		ms(arr, 0, arr.length-1);
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"w", "a", "c", "d", "aq", "gz", "zaa", "aa"};
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
    	
    	MergeSort.sort(arr);
    	
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
	}
}
