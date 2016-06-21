package csc364pa2;


/**
 * Created by Andrew Smiley on 6/18/16.
 * Class to represent Heapsort in true Java fashion
 * I'm not even going to look at the test runner. Literally just translating from Python
 */
public class InsertionSort {
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private int[] array;

    public InsertionSort(int[] array){
        this.array = array;
    }


    /**
     * This is the actual method to run the sort
     */
    public void doSort(){
        for (int i = 1; i < this.array.length; i++){
            //create our key and secondary index
            int k = this.array[i];
            int j= i-1;
            while(j >= 0 && k<this.array[j]){
                //do the swapping
                this.array[j+1]=this.array[j];
                //decrement
                j--;
            }
            this.array[j+1]=k;
        }


    }
}
