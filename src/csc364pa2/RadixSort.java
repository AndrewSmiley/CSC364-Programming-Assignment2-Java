package csc364pa2;

import java.util.Arrays;

/**
 * Created by Andrew Smiley on 6/18/16.
 * Class to represent RadixSort in true Java fashion
 */
public class RadixSort {

    /**
     * This method builds our buckets
     * @param n
     * @param exp
     */
    public static void radixCount(int[] array, int n, int exp){
        int outputBucket[] = new int[n];
        int countBucket[] = new int[10];
        Arrays.fill(countBucket,0);

        //these next two iterations build our count bucket
        for (int i = 0; i < n; i++)
            //added the ternary to put them in the first bucket if they're > 0 (negative)
            countBucket[ ((array[i]/exp)%10 > 0) ? (array[i]/exp)%10 : 1 ]++;

        for (int i = 1; i < 10; i++)
            countBucket[i] += countBucket[i - 1];

        // fill the output bucket
        for (int i = n - 1; i >= 0; i--)
        {
            //added the ternary to put them in the first bucket if they're > 0 (negative)
            outputBucket[countBucket[((array[i]/exp)%10 > 0) ? (array[i]/exp)%10 : 1] - 1] = array[i];
            countBucket[ Math.abs((array[i]/exp)%10) ]--;
        }
        //overwrite our input array
        for (int i = 0; i < n; i++)
            array[i] = outputBucket[i];

    }

    /**
     * This is the actual method to run the sort
     */
    public static void radixSort(int[] array){
        int maxSize = Integer.MAX_VALUE;
        //iterate and build our buckets
        for (int exp = 1; maxSize/exp > 0; exp *= 10) {
            radixCount(array, array.length, exp);
        }
        }

}
