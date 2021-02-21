import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.io.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * ------------------------------
 * numbers1000.txt
 * 
 * 		insertionSort: 5ms
 * 		selectionSort: 6ms
 * 		mergeSort: 2ms
 * 		quickSort: 1ms
 * ------------------------------
 * numbers10000.txt
 * 
 * 		insertionSort: 94ms
 * 		selectionSort: 35ms
 * 		mergeSort: 26ms
 * 		quickSort: 3ms
 * ------------------------------
 * numbers1000Duplicates.txt
 * 
 * 		insertionSort: 5ms
 * 		selectionSort: 7ms
 * 		mergeSort: 2ms
 * 		quickSort: 1ms
 * ------------------------------
 * numbersNearlyOrdered1000.txt
 * 
 * 		insertionSort: 1ms
 * 		selectionSort: 8ms
 * 		mergeSort: 2ms
 * 		quickSort: 1ms
 * ------------------------------
 * numbersReverse1000.txt
 * 
 * 		insertionSort: 11ms
 * 		selectionSort: 5ms
 * 		mergeSort: 2ms
 * 		quickSort: 1ms
 * ------------------------------
 * numbersSorted1000.txt
 * 
 * 		insertionSort: 0ms
 * 		selectionSort: 9ms
 * 		mergeSort: 0ms
 * 		quickSort: 1ms
 * ------------------------------
 */

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Eligijus Skersonas
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double a[] = {};
    	a = SortComparison.insertionSort(a);
    	assertEquals("Checking if insertionSort returns an empty array: ", "[]", Arrays.toString(a));
    	
    	double b[] = {};
    	b = SortComparison.selectionSort(b);
    	assertEquals("Checking if selectionSort returns an empty array: ", "[]", Arrays.toString(b));
    	
    	double c[] = {};
    	c = SortComparison.mergeSort(c);
    	assertEquals("Checking if mergeSort returns an empty array: ", "[]", Arrays.toString(c));
    	
    	double d[] = {};
    	d = SortComparison.quickSort(d);
    //	assertEquals("Checking if quickSort returns an empty array: ", "[]", Arrays.toString(d));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for single element arrays
     */
    @Test
    public void testSingleElement()
    {
    	double a[] = {1.5};
    	a = SortComparison.insertionSort(a);
    	assertEquals("Checking if insertionSort returns a single element array: ", "[1.5]", Arrays.toString(a));
    	
    	double b[] = {1.5};
    	b = SortComparison.selectionSort(b);
    	assertEquals("Checking if selectionSort returns a single element array: ", "[1.5]", Arrays.toString(b));
    	
    	double c[] = {1.5};
    	c = SortComparison.mergeSort(c);
    	assertEquals("Checking if mergeSort returns a single element array: ", "[1.5]", Arrays.toString(c));
    	
    	double d[] = {1.5};
    	d = SortComparison.quickSort(d);
    	assertEquals("Checking if quickSort returns a single element array: ", "[1.5]", Arrays.toString(d));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for sorted arrays
     */
    @Test
    public void testSorted()
    {
    	double a[] = {-2.3,0,1,2,3,4,5,6};
    	a = SortComparison.insertionSort(a);
    	assertEquals("Checking if insertionSort returns the sorted array: ", "[-2.3, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(a));
    	
    	double b[] = {-2.3,0,1,2,3,4,5,6};
    	b = SortComparison.selectionSort(b);
    	assertEquals("Checking if selectionSort returns the sorted array: ", "[-2.3, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(b));
    	
    	double c[] = {-2.3,0,1,2,3,4,5,6,7,8,9,10,11,12,13};
    	c = SortComparison.mergeSort(c);
    	assertEquals("Checking if mergeSort returns the sorted array: ", "[-2.3, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0]", Arrays.toString(c));
    	
    	double d[] = {-2.3,0,1,2,3,4,5,6};
    	d = SortComparison.quickSort(d);
    	assertEquals("Checking if quickSort returns the sorted array: ", "[-2.3, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(d));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testNotSorted()
    {
    	double a[] = {5,4.4,4.5,4.1,1,0,-2.5,9.3};
    	a = SortComparison.insertionSort(a);
    	assertEquals("Checking if insertionSort returns a sorted array: ", "[-2.5, 0.0, 1.0, 4.1, 4.4, 4.5, 5.0, 9.3]", Arrays.toString(a));
    	
    	double b[] = {5,4.4,4.5,4.1,1,0,-2.5,9.3};
    	b = SortComparison.selectionSort(b);
    	assertEquals("Checking if selectionSort returns a sorted array: ", "[-2.5, 0.0, 1.0, 4.1, 4.4, 4.5, 5.0, 9.3]", Arrays.toString(b));
    	
    	double c[] = {10,9,8,7,6,5,4,3,2,1,0,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
    	c = SortComparison.mergeSort(c);
    	assertEquals("Checking if mergeSort returns a sorted array: ", "[-11.0, -10.0, -9.0, -8.0, -7.0, -6.0, -5.0, -4.0, -3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0]", Arrays.toString(c));
    	
    	double d[] = {10,1,2,3,4,11,12,13,14};
    	d = SortComparison.quickSort(d);
    	assertEquals("Checking if quickSort returns a sorted array: ", "[1.0, 2.0, 3.0, 4.0, 10.0, 11.0, 12.0, 13.0, 14.0]", Arrays.toString(d));
    	

    	double e[] = {10,11,12,13};
    	e = SortComparison.quickSort(e);
    	assertEquals("Checking if quickSort returns a sorted array: ", "[10.0, 11.0, 12.0, 13.0]", Arrays.toString(e));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for arrays that contain duplicates
     */
    @Test
    public void testDuplicates()
    {
    	double a[] = {1,1,0,3,4,1,-1,-3.2,0,2,-3.2};
    	a = SortComparison.insertionSort(a);
    	assertEquals("Checking if insertionSort returns an empty array: ", "[-3.2, -3.2, -1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 3.0, 4.0]", Arrays.toString(a));
    	
    	double b[] = {1,1,0,3,4,1,-1,-3.2,0,2,-3.2};
    	b = SortComparison.selectionSort(b);
    	assertEquals("Checking if selectionSort returns an empty array: ", "[-3.2, -3.2, -1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 3.0, 4.0]", Arrays.toString(b));
    	
    	double c[] = {-1,-1,0,-3,-4,-5,1,1,3.2,0,2,3.2};
    	c = SortComparison.mergeSort(c);
    	assertEquals("Checking if mergeSort returns an empty array: ", "[-5.0, -4.0, -3.0, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0, 2.0, 3.2, 3.2]", Arrays.toString(c));
    	
    	double d[] = {1,1,0,3,4,1,-1,-3.2,0,2,-3.2};
    	d = SortComparison.quickSort(d);
    	assertEquals("Checking if quickSort returns an empty array: ", "[-3.2, -3.2, -1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 3.0, 4.0]", Arrays.toString(d));
    }
    
    
    
    
    


    

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws IOException 
     * @throws NumberFormatException 
     *
     */
    /*
    public static void main(String[] args) throws NumberFormatException, IOException
    {	
    	File file = new File("/Users/eli_scorpio/CS/A&D2/Assignments/Assignment1/numbers10000.txt");
    	FileReader fr = new FileReader(file);
    	BufferedReader br = new BufferedReader(fr);
    	double[] numbers = new double[10000];
    	String string = "";
    	
    	for(int i = 0; i < 10000; i++) {
    		string = br.readLine();
    		if(string != null)
    			numbers[i] = Double.parseDouble(string);
    	}
    	
    	double[] a = numbers.clone();
    			
        long start = System.currentTimeMillis();
        SortComparison.insertionSort(a);
        long end = System.currentTimeMillis();
        System.out.println("InsertionSort: " + (end-start));
        
        a = numbers.clone();
        start = System.currentTimeMillis();
        SortComparison.selectionSort(a);
        end = System.currentTimeMillis();
        System.out.println("selectionSort: " + (end-start));
        
        a = numbers.clone();
        start = System.currentTimeMillis();
        SortComparison.mergeSort(a);
        end = System.currentTimeMillis();
        System.out.println("mergeSort: " + (end-start));
        
        a = numbers.clone();
        start = System.currentTimeMillis();
        SortComparison.quickSort(a);
        end = System.currentTimeMillis();
        System.out.println("quickSort: " + (end-start));
        
    }
    */
    
}


