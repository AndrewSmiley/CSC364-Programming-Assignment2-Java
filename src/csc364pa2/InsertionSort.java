package csc364pa2;


/**
 * Created by Andrew Smiley on 6/18/16.
 * Class to represent Heapsort in true Java fashion
 * I'm not even going to look at the test runner. Literally just translating from Python
 */
public class InsertionSort {

    /**
     * This is the actual method to run the sort
     */
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            //create our key and secondary index
            int k = array[i];
            int j= i-1;
            while(j >= 0 && k<array[j]){
                //do the swapping
                array[j+1]=array[j];
                //decrement
                j--;
            }
            array[j+1]=k;
        }


    }
}
