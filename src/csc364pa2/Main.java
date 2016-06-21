package csc364pa2;

import java.io.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    //doing this the java way... which is crap
        //ok so we CAN reuse these I do believe
        //yep, we'll pass these by value
        int[] sorted_one = new int[100];
        int[] unsorted_one = new int[100];
        int[] sorted_two = new int[200];
        int[] unsorted_two = new int[200];
        Random rand = new Random();
        for (int i = 0; i < 100; i++){
            sorted_one[i] =i+1;
            unsorted_one[i] = 1 + rand.nextInt((100-1) +1);
        }
        for (int i = 0; i < 200; i++){
            sorted_two[i] =i+1;
            unsorted_two[i] = 1 + rand.nextInt((200-1) +1);
        }

        //redirect stdio to file
        try {
            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("timings.txt"))));
        } catch (FileNotFoundException e) {
            //basically if timings doesn't exist, let's try to create it and try the above again
            File newFile = new File("timings.txt");
            if(!newFile.exists()) {
                try {
                    newFile.createNewFile();
                    System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("timings.txt"))));
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.exit(-1);
                }
            }
            System.exit(-1);
        }
        //do the heap sort first
        System.out.println("================================================");
        System.out.println("Heap Sort Outputs");
        System.out.println("================================================");
        long start = System.nanoTime();
        //do the sorted 100kfirst
        HeapSort heapSort = new HeapSort(sorted_one);
        heapSort.doSort();
        long end = System.nanoTime();
        System.out.println("Sorted 100k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");
        System.out.println("Unsorted 100k items");
        heapSort.setArray(unsorted_one);
        start =System.nanoTime();
        heapSort.doSort();
        end= System.nanoTime();
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");
        System.out.println("Sorted 200k items");
        heapSort.setArray(sorted_two);
        start =System.nanoTime();
        heapSort.doSort();
        end= System.nanoTime();
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");
        System.out.println("Unsorted 200k items");
        heapSort.setArray(unsorted_two);
        start =System.nanoTime();
        heapSort.doSort();
        end= System.nanoTime();
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");

        //next do the insertion sort
        System.out.println("================================================");
        System.out.println("Insertion Sort Outputs");
        System.out.println("================================================");
        InsertionSort insertionSort = new InsertionSort(sorted_one);
        start=  System.nanoTime();
        insertionSort.doSort();
        end =System.nanoTime();
        System.out.println("Sorted 100k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");
        insertionSort.setArray(unsorted_one);
        start=  System.nanoTime();
        insertionSort.doSort();
        end =System.nanoTime();
        System.out.println("Unsorted 100k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");

        insertionSort.setArray(sorted_two);
        start=  System.nanoTime();
        insertionSort.doSort();
        end =System.nanoTime();
        System.out.println("Sorted 200k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");

        insertionSort.setArray(unsorted_two);
        start=  System.nanoTime();
        insertionSort.doSort();
        end =System.nanoTime();
        System.out.println("Unsorted 200k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");


        //finally, do our radix sort
        //next do the insertion sort
        System.out.println("================================================");
        System.out.println("Radix Sort Outputs");
        System.out.println("================================================");
        RadixSort radixSort =new RadixSort(sorted_one);
        start= System.nanoTime();
        radixSort.doSort();
        end=System.nanoTime();
        System.out.println("Sorted 100k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");
        radixSort.setArray(unsorted_one);
        start= System.nanoTime();
        radixSort.doSort();
        end=System.nanoTime();
        System.out.println("Unsorted 100k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");

        radixSort.setArray(sorted_two);
        start= System.nanoTime();
        radixSort.doSort();
        end=System.nanoTime();
        System.out.println("Sorted 200k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");

        radixSort.setArray(unsorted_two);
        start= System.nanoTime();
        radixSort.doSort();
        end=System.nanoTime();
        System.out.println("Unsorted 200k items");
        System.out.println("Time elapsed: "+Long.toString(end-start)+" milliseconds\n");

    }
}
