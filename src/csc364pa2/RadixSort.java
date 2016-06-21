package csc364pa2;

import java.util.Arrays;

/**
 * Created by Andrew Smiley on 6/18/16.
 * Class to represent RadixSort in true Java fashion
 */
public class RadixSort {
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private int[] array;

    public RadixSort(int[] array){
        this.array = array;
    }

    /**
     * This method builds our buckets
     * @param n
     * @param exp
     */
    public void radixCount(int n, int exp){
        int outputBucket[] = new int[n];
        int countBucket[] = new int[10];
        Arrays.fill(countBucket,0);

        //these next two iterations build our count bucket
        for (int i = 0; i < n; i++)
            countBucket[ (this.array[i]/exp)%10 ]++;

        for (int i = 1; i < 10; i++)
            countBucket[i] += countBucket[i - 1];

        // fill the output bucket
        for (int i = n - 1; i >= 0; i--)
        {
            outputBucket[countBucket[ (this.array[i]/exp)%10 ] - 1] = this.array[i];
            countBucket[ (this.array[i]/exp)%10 ]--;
        }
        //overwrite our input array
        for (int i = 0; i < n; i++)
            this.array[i] = outputBucket[i];

    }

    /**
     * This is the actual method to run the sort
     */
    public void doSort(){
        int maxSize = Integer.MAX_VALUE;
        //iterate and build our buckets
        for (int exp = 1; maxSize/exp > 0; exp *= 10) {
            radixCount(this.array.length, exp);
        }
        }

}
