package csc364pa2;

/**
 * Created by Andrew Smiley on 6/18/16.
 * Class to represent Heapsort in true Java fashion
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
     * Our build-heap method (this is Java, it's methods not functions)
     * @param size the length of the array
     * @param index the index
     */
    public void heapify(int size, int index){
        //our root node
        int root = index;
        //left adn right subtrees
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left < size &&   this.array[root]< this.array[left])
            root = left;

        if (right < size &&  this.array[root] < this.array[right] )
            root = right;

        // If largest is not root
        if (root != index)
        {
            //do our swap
            int swap = this.array[root];
            this.array[root] = this.array[index];
            this.array[index] = swap;
            //recurse
            heapify(size, root);
        }

    }
    /**
     * This is the actual method to run the sort
     */
    public void doSort(){
        int length = this.array.length;

        // Build the heap
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(length, i);

        //reduce the heap
        for (int i=length-1; i>=0; i--)
        {
            int temp = this.array[0];
            this.array[0] = this.array[i];
            this.array[i] = temp;

            //rebuild heap
            heapify(i, 0);
        }

    }
}
