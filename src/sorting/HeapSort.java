package sorting;

public class HeapSort {
	private static int N;
    public static <T extends Comparable<T>> void sort(T[] arr) {
    	

        heapify(arr);        

        for (int i = N; i > 0; i--){
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }

    }     

    /* Function to build a heap */   

    public static <T extends Comparable<T>> void heapify(T[] arr) {
        N = arr.length-1;

        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }


    public static <T extends Comparable<T>> void maxheap(T[] arr, int i) { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        
        if (left <= N && arr[left].compareTo(arr[i]) > 0)
            max = left;

        if (right <= N && arr[right].compareTo(arr[max]) > 0)        
            max = right;

 

        if (max != i){
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j){
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    

	public static void main(String[] args) {
		String[] arr = {"w", "a", "c", "d", "aq", "gz", "zaa", "aa"};
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
    	
    	HeapSort.sort(arr);
    	
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
	}
}
