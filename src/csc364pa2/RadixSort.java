package csc364pa2;

import java.util.Arrays;

/**
 * Created by Andrew Smiley on 6/18/16.
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
     * @param exp
     */
    public void radixCount(int exp){
        int length = this.array.length;
        int[] countBucket = new int[10];
        int[] outBucket = new int[length];
        //fill with zeros
        Arrays.fill(countBucket, 0);
        Arrays.fill(outBucket, 0);
        /*
        Build our buckets
         */
        for(int i = 0; i < length; i++){
            int index = (this.array[i]/exp);
            countBucket[ index %10 ] = countBucket[ index %10 ]+1;
        }

        for(int i = 1; i < 10; i++){
            countBucket[i] = countBucket[i-1]+countBucket[i];
        }
        //guess i could make this a for loop
        int i = length-1;
        while(i >=0) {
            int index = (this.array[i] / exp);
            outBucket[countBucket[(index) % 10] - 1] = this.array[i];
            countBucket[(index) % 10]--;
            i--;
        }
        for(int j=0; i < length;i++){
            this.array[j] = outBucket[j];
        }

    }

    /**
     * This is the actual method to run the sort
     */
    public void doSort(){
        int maxSize = Integer.MAX_VALUE;
        int exp =1;
        while (maxSize/exp > 0){
            this.radixCount(exp);
            exp *=10;
        }
    }
}
