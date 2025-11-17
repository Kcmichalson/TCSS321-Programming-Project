package sorts;

import generators.SortMetrics;
import generators.Sorter;

/**
 * SelectionSort class
 * Sorts an array using Selection Sort.
 * Performance doesn't improve on already sorted lists.
 *
 * @author Kc
 * @version 11/16/25
 */
public class SelectionSort implements Sorter {

    /**
     * @param array Array to be sorted.
     * @return SortMetrics object containing the comparison and swap counts.
     */
    public SortMetrics sort(int[] array) {
        int comparisons = 0;
        int swaps = 0;

        // move the boundary of the unsorted part
        for (int outer = 0; outer < array.length - 1; outer++) {

            // find the minimum element
            int minIndex = outer;
            for (int inner = outer + 1; inner < array.length; inner++) {

                // comparison counter
                comparisons++;
                if (array[inner] < array[minIndex]) {
                    minIndex = inner;
                }
            }

            // swap the minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[outer];
            array[outer] = temp;

            // swap counter
            swaps++;
        }

        return new SortMetrics(comparisons, swaps);
    }
}