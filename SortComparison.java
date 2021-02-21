import java.util.Random;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Eligijus Skersonas
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort. 
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	
    	for(int i = 1; i < a.length; i++) {
    		
    		int j = i - 1;
    		double currentKey = a[i];
    		
    		// If j is not less than 0 and is greater than the currentKey
    		// move it up one position in the array and decrement j
    		while(j >= 0 && a[j] > currentKey)
    			a[j + 1] = a[j--];
    		
    		// Swap currentKey with a[j+1]
    		// (i.e put currentKey in the position where the key to its right
    		//  is greater than currentKey and the key to its left is less than
    		//  or equal to currentKey
    		a[j + 1]  = currentKey;		
    	}
        
    	return a;
    }//end insertionSort
	
	/**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	for(int i = 0; i < a.length-1; i++) {
    		
    		// set i as the current minIndex
    		int minIndex = i;
    		
    		// traverse through the array starting at i+1 to find the smallest key
    		// set minIndex to the smallest keys index
    		for(int j = i + 1; j < a.length; j++)
    			if(a[j] < a[minIndex])
    				minIndex = j;
    		
    		// if minIndex is the same as i then don't swap since it's already in the 
    		// correct position, otherwise swap the key at minIndex with the key at index i
    		if(minIndex != i) {
	    		double temp = a[i];
	    		a[i] = a[minIndex];
	    		a[minIndex] = temp;
    		}
    			
    	
    	}
    	
    	return a;

    }//end selectionSort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
    	//call recursiveQuickSort
    	fisherYatesShuffle(a);
		recursiveQuickSort(a, 0, a.length-1);
    	return a;

    }//end quickSort
    
    private static void fisherYatesShuffle(double[] a)
    {
        int index;
        double temp;
        Random random = new Random();
        
        for (int i = a.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }
    
    private static void recursiveQuickSort(double[] a, int lo, int hi) {
    	//if array/subarray is a single element or empty return;
    	if(hi <= lo) 
    		return;
    	
    	// partition the array and return the pivot
    	int pivotIndex = partition(a, lo, hi);
    	
    	// call recursiveQuickSort for the sub array to the left of the pivot
    	recursiveQuickSort(a, lo, pivotIndex-1);
    	//call recurisveQuickSort for the sub array to the right of the pivot
    	recursiveQuickSort(a, pivotIndex+1, hi);
    }
    
    private static int partition(double a[], int lo, int hi) {
    	//set i to lo and j to hi+1 (since we do --j)
    	int i = lo;
    	int j = hi+1;
    	
    	//set pivot to the first element in the array
    	double pivot = a[lo];
    	
    	//keep looping until i and j cross each other
    	while(true) {
	    	
    		// keep iterating from the left until we reach an element thats bigger than the pivot
    		// if we reach the end of the array break
    		while((a[++i] < pivot)) 
	    		if(i == hi) 
	    			break;
	    	
    		// keep iterating from the left until we reach an element thats less than or equal to the pivot
	    	// if we reach the start of the array break
    		while((pivot <= a[--j]))
	    		if(j == lo) 
	    			break;
	    	
    		// if i and j cross each other break
	    	if(i >= j) 
	    		break;
	    	
	    	// swap the elements positioned at i and j
	    	double temp = a[i];
	    	a[i] = a[j];
	    	a[j] = temp;
	    }
    		// swap the pivot with j
	    	a[lo] = a[j];
	    	a[j] = pivot;
	    	
	    	// return the pivot
	    	return j;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSort (double a[]) {
    	
    	// make an auxiliary array
    	double[] aux = new double[a.length];
    	// call recursive sort method
    	sort(a, aux, 0, a.length-1);
    	return a;

    }//end mergeSort
    
    private static void sort (double a[], double aux[], int lo, int hi) {
    	
    	// Cutoff to when we use use insertionSort is ~ 10 items
    	// It is faster to use insertion sort at that point
    	final int INSERTION_SORT_CUTOFF = 10;
    	
    	// If number of items is less than or equal to 10 use insertionSort
    	if(hi <= lo + INSERTION_SORT_CUTOFF - 1) {
    		SortComparison.insertionSortForMerge(a, lo, hi);
    		return;
    	}
    	
    	// mid is calculated like so to avoid an integer overflow
    	int mid = lo + (hi-lo)/2;
    	
    	// Call recursive sort for the left half
    	sort(a, aux, lo, mid);
    	// Call recursive sort for the right half
    	sort(a, aux, mid+1, hi);
    	
    	// If the key at the end of the left half is less than
    	// the key at the start of the right half then the two halves
    	// don't need to merged since they are already in terms of one another sorted
    	if(less(a[mid], a[mid + 1])) return;
    	
    	merge(a, aux, lo, mid, hi);
    }
    
    private static void merge (double a[], double aux[], int lo, int mid, int hi) {
    	
    	// Copy the contents of the array a into the auxiliary array
    	for(int i = 0; i < aux.length; i++)
    		aux[i] = a[i];
    	
    	// Initialize leftIndex to point at the start of the left half
    	int leftIndex = lo; 
    	// Initialize rightIndex to point at the start of the right half
    	int rightIndex = mid + 1;
    	
    	// Merge the two halves into one sorted component
    	for(int currentIndex = lo; currentIndex <= hi; currentIndex++) {
    		if(leftIndex > mid) 
    			a[currentIndex] = aux[rightIndex++];
    		else if(rightIndex > hi) 
    			a[currentIndex] = aux[leftIndex++];
    		else if(less(aux[rightIndex], aux[leftIndex])) 
    			a[currentIndex] = aux[rightIndex++];
    		else 
    			a[currentIndex] = aux[leftIndex++];
    	}
    }
    
    private static double [] insertionSortForMerge (double a[], int lo, int hi){
    	
    	for(int i = lo+1; i < hi+1; i++) {
    		
    		int j = i - 1;
    		double currentKey = a[i];
    		
    		// If j is not less than 0 and is greater than the currentKey
    		// move it up one position in the array and decrement j
    		while(j >= lo && a[j] > currentKey)
    			a[j + 1] = a[j--];
    		
    		// Swap currentKey with a[j+1]
    		// (i.e put currentKey in the position where the key to its right
    		//  is greater than currentKey and the key to its left is less than
    		//  or equal to currentKey
    		a[j + 1]  = currentKey;		
    	}
        
    	return a;
    }
    
    // check if a is less than b returning a boolean value
    private static boolean less(double a, double b) {
    	return a < b;
    }
    

 }//end class

