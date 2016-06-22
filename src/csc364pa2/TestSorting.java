package csc364pa2;// TestSorting.java
// Tests and times the following sorting methods on sorted and unsorted arrays
// of various sizes:
//      InsertionSort.insertionSort(int[] list)
//      InPlaceIntHeapSort.heapSort(int[] list)
//      RadixSort.radixSort(int[] array)
//
// by Jeff Ward

import java.util.Random;
import java.io.*;

public class TestSorting
{
	private static PrintWriter outFile;
	
	public static void main(String[] args) throws IOException
	{
		outFile = new PrintWriter("Timings.txt");
		
		int[] sizes	= { 100000, 200000 };
		
		for (int n: sizes)
		{
			int[] orderedArray = generateOrdered(n);
			int[] randomArray = generateRandom(n);
			int[] copy;
			
			// Insertion sort tests
			testInsertionSort(orderedArray, true);
			copy = copyArray(randomArray);
			testInsertionSort(copy, false);
			
			// Quick sort tests
			testHeapSort(orderedArray, true);
			copy = copyArray(randomArray);
			testHeapSort(copy, false);

			// Radix sort tests
			testRadixSort(orderedArray, true);
			copy = copyArray(randomArray);
			testRadixSort(copy, false);
		}
		
		outFile.close();
	}
	
	static void testInsertionSort(int[] array, boolean ordered)
	{
		long startTime = System.currentTimeMillis();
		InsertionSort.insertionSort(array);		
		long endTime = System.currentTimeMillis();
		long timeToSolve = endTime - startTime; // Time in milliseconds
		output("Insertion sort "
						+ "runtime on "
						+ (ordered ? "ordered" : "random ")
						+ " array of length "
						+ array.length + ":  "
						+ timeToSolve + " milliseconds");
						
		if (checkSorted(array))
		{
			output("Insertion sort verified.");
			output();
		}
		else
		{
			output("Insertion sort failed.");
			System.exit(1);
		}
	}
	
	static void testHeapSort(int[] array, boolean ordered)
	{
		long startTime = System.currentTimeMillis();	
		InPlaceIntHeapSort.heapSort(array);		
		long endTime = System.currentTimeMillis();
		long timeToSolve = endTime - startTime; // Time in milliseconds
		output("Heap sort "
						+ "runtime on "
						+ (ordered ? "ordered" : "random ")
						+ " array of length "
						+ array.length + ":  "
						+ timeToSolve + " milliseconds");
		
		if (checkSorted(array))
		{
			output("Heap sort verified.");
			output();
		}
		else
		{
			output("Heap sort failed.");
			System.exit(1);
		}
	}
	
	static void testRadixSort(int[] array, boolean ordered)
	{
		long startTime = System.currentTimeMillis();
		RadixSort.radixSort(array);		
		long endTime = System.currentTimeMillis();
		long timeToSolve = endTime - startTime; // Time in milliseconds
		output("Radix sort "
						+ "runtime on "
						+ (ordered ? "ordered" : "random ")
						+ " array of length "
						+ array.length + ":  "
						+ timeToSolve + " milliseconds");
						
		if (checkSorted(array))
		{
			output("Radix sort verified.");
			output();
		}
		else
		{
			output("Radix sort failed.");
			System.exit(1);
		}
	}
	
	static int[] generateRandom(int n)
	// Generate an array of n random integers.
	{
		Random generator = new Random();
		int[] array = new int[n];
				
		for (int i = 0; i < n; i++)
		{
			array[i] = generator.nextInt();	
		}
		
		return array;
	}
	
	static int[] generateOrdered(int n)
	// Generate an array consisting of the integers 0, 1, 2, ..., n-1.
	{
		int[] array = new int[n];
				
		for (int i = 0; i < n; i++)
		{
			array[i] = i;	
		}
		
		return array;
	}
		
	static int[] copyArray(int[] array)
	{
		int n = array.length;
		int[] returnVal = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			returnVal[i] = array[i];
		}
		
		return returnVal;
	}
	
	static boolean checkSorted(int[] array)
	{
		int n = array.length;
		for (int i = 0; i <= n - 2; i++)
		{
			if (array[i] > array[i + 1])
			{
				return false;	
			}	
		}
		
		return true;
	}
	
	static void displayArray(int[] array)
	{
		for (int val: array)
		{
			System.out.print(" " + val);	
		}
		System.out.println();
	}
	
	static void output(String s)
	{
		System.out.println(s);
		outFile.println(s);	
	}
	
	static void output()
	{
		output("");	
	}
}
