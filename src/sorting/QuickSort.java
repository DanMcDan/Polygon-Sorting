package sorting;

public class QuickSort {
	
	public static <T extends Comparable<T>> void sort(T[] list) {
		qs(list,0,list.length-1);
	}
	
	private static <T extends Comparable<T>> void qs(T[] list, int left, int right) {
		
        int index = partition(list, left, right);
        
        if (left < index - 1)	qs(list, left, index - 1);
        if (index < right)	qs(list, index, right);
    }

    private static <T extends Comparable<T>> int partition(T list[], int left, int right) {
        int low = left, 
            high = right;
        
        T	temp = null,
        	pivot = list[(left + right) / 2];

            while (low <= high) {
                while (list[low].compareTo(pivot) < 0) {
                    low++;
                }
                while (list[high].compareTo(pivot) > 0) {
                    high--;
                }
                if (low <= high) {
                    temp = list[low];
                    list[low] = list[high];
                    list[high] = temp;
                    low++;
                    high--;
                }
            }
        return low;
    }
    
    public static void main(String[] args) {    	
    	String[] arr = {"w", "a", "c", "d", "aq", "gz", "zaa", "aa"};
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
    	
    	QuickSort.sort(arr);
    	
    	System.out.print("[");
    	for(int i = 0; i < arr.length; i++) {
    		if (i < arr.length-1) System.out.print(arr[i] + ", ");
    		else System.out.println(arr[i] + "]");
    	}
    }
}
