package csc364pa2;

/**
 * Created by pridemai on 6/20/16.
 */
public class HeapSort {
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private int[] array;
    public HeapSort(int array[]){
        this.array = array;
    }
    /**
     * Our build-heap method (this is Java, it's methods not functions
     * @param n the length of the array
     * @param i the index
     */
    public void heapify(int n, int i){
        //our max value
        int max = i;
        //left and right branches
        int left = 2 *i+1;
        int right = 2 *i+2;
        if(left< n && this.array[max] < this.array[left]){
            max = left;
        }
        if (right < n && this.array[max] < this.array[right]){
            max = right;
        }
        //if the max value is not at the root
        if(max != i){
            //swap
            int temp = this.array[0];
            this.array[0] =this.array[max];
            this.array[max]= temp;
            //recurse
            heapify(n, max);
        }

    }
    /**
     * This is the actual method to run the sort
     */
    public void doSort(){
        int length = this.array.length;
        //here we'll build the heap
        for(int i = length/2-1; i >= 0;i--){
            heapify(length, i);
        }
        //reduce the heap
        for(int i = length-1; i >= 0; i--){
            //and swap, thanks Java, no swap method
            int temp = this.array[0];
            this.array[0]=this.array[i];
            this.array[i]=temp;
            heapify(i, 0);
        }

    }
}
