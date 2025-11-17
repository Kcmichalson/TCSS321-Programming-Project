package sorts;

import generators.SortMetrics;
import generators.Sorter;

/**
 * InsertionSort class
 * Sorts array using Insertion Sort.
 * Performance improves on already sorted lists.
 *
 * @author Kc
 * @version 11/16/25
 */

public class InsertionSort implements Sorter {

    /**
     * @param array Array to be sorted.
     * @return SortMetrics object containing the comparison and swap counts.
     */
    public SortMetrics sort(int[] array) {
        int comparisons = 0;
        int swaps = 0;

        // Starting from second element
        for (int outer = 1; outer < array.length; outer++) {
            // Element to insert
            int key = array[outer];
            int inner = outer - 1;

            // Move elements that are greater than key one position ahead.
            comparisons++; // for the first check
            while (inner >= 0 && array[inner] > key) {
                // for subsequent checks
                if(inner > 0) comparisons++;

                // shift the whole array
                array[inner + 1] = array[inner];
                swaps++;
                inner = inner - 1;
            }
            // Place the key in its correct spot
            array[inner + 1] = key;
            swaps++;
        }

        return new SortMetrics(comparisons, swaps);
    }
}