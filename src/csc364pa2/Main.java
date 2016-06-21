package csc364pa2;

import java.io.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //06/18
        //doing this the java way... which is crap
        //ok so we CAN reuse these I do believe
        //yep, we'll pass these by value

        //06/21/2016
        //i lied. they're passed by value to the constructor, but to use setArray() they're passed by value
        //which screws things up for us. Soo.... we're going to do this
        int[] sorted_one = new int[100000];
        int[] unsorted_one = new int[100000];
        int[] sorted_two = new int[200000];
        int[] unsorted_two = new int[200000];
        Random rand = new Random();
        //fill in preparation of our first sorting excursion
        for (int i = 0; i < 100000; i++) {
            sorted_one[i] = i + 1;
            unsorted_one[i] = 1 + rand.nextInt((100000 - 1) + 1);
        }
        for (int i = 0; i < 200000; i++) {
            sorted_two[i] = i + 1;
            unsorted_two[i] = 1 + rand.nextInt((200000 - 1) + 1);
        }

        //redirect stdio to file
        //thanks iainmackay85 http://stackoverflow.com/questions/14552342/redirect-lots-of-system-out-printlns-to-a-txt-file
        PrintStream ps = null;
        PrintStream orig = System.out;
        try {
            ps = new PrintStream("timings.txt");
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        System.setOut(ps);

        //do the heap sort first
        System.out.println("================================================");
        System.out.println("Heap Sort Outputs");
        System.out.println("================================================");
        long start = System.nanoTime();
        //do the sorted 100000kfirst
        HeapSort heapSort = new HeapSort(sorted_one);
        heapSort.doSort();
        long end = System.nanoTime();
        System.out.println("Sorted 100k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        System.out.println("Unsorted 100k items");
        heapSort.setArray(unsorted_one);
        start = System.nanoTime();
        heapSort.doSort();
        end = System.nanoTime();
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        System.out.println("Sorted 200k items");
        heapSort.setArray(sorted_two);
        start = System.nanoTime();
        heapSort.doSort();
        end = System.nanoTime();
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        System.out.println("Unsorted 200k items");
        heapSort.setArray(unsorted_two);
        start = System.nanoTime();
        heapSort.doSort();
        end = System.nanoTime();
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");


        //so now we have to replace the elements in this guy
        for (int i = 0; i < 100000; i++) {
            sorted_one[i] = i + 1;
            unsorted_one[i] = 1 + rand.nextInt((100000 - 1) + 1);
        }
        for (int i = 0; i < 200000; i++) {
            sorted_two[i] = i + 1;
            unsorted_two[i] = 1 + rand.nextInt((200000 - 1) + 1);
        }
        //next do the insertion sort
        System.out.println("================================================");
        System.out.println("Insertion Sort Outputs");
        System.out.println("================================================");
        InsertionSort insertionSort = new InsertionSort(sorted_one);
        start = System.nanoTime();
        insertionSort.doSort();
        end = System.nanoTime();
        System.out.println("Sorted 100k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        insertionSort.setArray(unsorted_one);
        start = System.nanoTime();
        insertionSort.doSort();
        end = System.nanoTime();
        System.out.println("Unsorted 100k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");

        insertionSort.setArray(sorted_two);
        start = System.nanoTime();
        insertionSort.doSort();
        end = System.nanoTime();
        System.out.println("Sorted 200k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");

        insertionSort.setArray(unsorted_two);
        start = System.nanoTime();
        insertionSort.doSort();
        end = System.nanoTime();
        System.out.println("Unsorted 200k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        //replace again
        for (int i = 0; i < 100000; i++) {
            sorted_one[i] = i + 1;
            unsorted_one[i] = 1 + rand.nextInt((100000 - 1) + 1);
        }
        for (int i = 0; i < 200000; i++) {
            sorted_two[i] = i + 1;
            unsorted_two[i] = 1 + rand.nextInt((200000 - 1) + 1);
        }
        //finally, do our radix sort
        System.out.println("================================================");
        System.out.println("Radix Sort Outputs");
        System.out.println("================================================");
        RadixSort radixSort = new RadixSort(sorted_one);
        start = System.currentTimeMillis();
        radixSort.doSort();
        end = System.currentTimeMillis();
        System.out.println("Sorted 100k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        radixSort.setArray(unsorted_one);
        start = System.currentTimeMillis();
        radixSort.doSort();
        end = System.currentTimeMillis();
        System.out.println("Unsorted 100k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");

        radixSort.setArray(sorted_two);
        start = System.currentTimeMillis();
        radixSort.doSort();
        end = System.currentTimeMillis();
        System.out.println("Sorted 200k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");

        radixSort.setArray(unsorted_two);
        start = System.currentTimeMillis();
        radixSort.doSort();
        end = System.currentTimeMillis();
        System.out.println("Unsorted 200k items");
        System.out.println("Time elapsed: " + Long.toString(end - start) + " milliseconds\n");
        //we have to do this
        System.setOut(orig);
        //close the file
        ps.close();
    }
}
