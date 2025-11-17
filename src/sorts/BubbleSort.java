package sorts;

import generators.SortMetrics;
import generators.Sorter;

/**
 * BubbleSort class
 * Sorts an array using Bubble Sort.
 * Can stop early.
 *
 * @author Kc
 * @version 11/16/25
 */

public class BubbleSort implements Sorter {
    /**
     *  @param array Array to be sorted.
     *  @return SortMetrics object containing the comparison and swap counts.
     */
    public SortMetrics sort(int[] array) {
        int comparisonCount = 0;
        int swapCount = 0;
        int arrayLength = array.length;

        // outer
        for (int a = 0; a < arrayLength - 1; a++) {

            // flag
            boolean swapped = false;

            // inner
            for (int b = 0; b < arrayLength - a - 1; b++) {

                // comparison counter
                comparisonCount++;
                if (array[b] > array[b + 1]) {
                    // if out of order;
                    int heldElement = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = heldElement;

                    // swap counter
                    swapCount++;
                    swapped = true;
                }
            }

            if (!swapped) {
                return new SortMetrics(comparisonCount, swapCount);
            }
        }

        return new SortMetrics(comparisonCount, swapCount);
    }
}