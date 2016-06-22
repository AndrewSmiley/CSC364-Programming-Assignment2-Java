package csc364pa2;

/**
 * Created by Andrew Smiley on 6/18/16.
 * Class to represent Heapsort in true Java fashion
 */
public class InPlaceIntHeapSort {

    /**
     * Our build-heap method (this is Java, it's methods not functions)
     * @param size the length of the array
     * @param index the index
     */
    public static void heapify(int[] array,int size, int index){
        //our root node
        int root = index;
        //left adn right subtrees
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left < size &&   array[root]< array[left])
            root = left;

        if (right < size &&  array[root] < array[right] )
            root = right;

        // If largest is not root
        if (root != index)
        {
            //do our swap
            int swap = array[root];
            array[root] = array[index];
            array[index] = swap;
            //recurse
            heapify(array,size, root);
        }

    }
    /**
     * This is the actual method to run the sort
     */
    public static void heapSort(int[] array){
//        this.setArray(array);
        int length = array.length;

        // Build the heap
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        //reduce the heap
        for (int i=length-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //rebuild heap
            heapify(array,i, 0);
        }

    }
}
