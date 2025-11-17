import generators.Sorter;
import sorts.BubbleSort;
import sorts.InsertionSort;
import sorts.SelectionSort;
import generators.ArrayGenerator;
import generators.SortMetrics;

import java.util.Arrays;

/**
 * Main class for running the sorting algorithm comparison experiment.
 *
 * @author Kc
 * @version 11/16/25
*/
public class Main {

    public static void main(String[] args) {

        // The array sizes to test
        int[] testSizes = {100, 500, 1000, 2500, 5000, 10000};

        // Instances of sorting algorithms
        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();

        // have to print this first so the sheet doesn't break
        System.out.println("Algorithm,ArrayType,Size,Comparisons,Swaps,Time(ms)");

        // Loop over each defined test
        for (int size : testSizes) {

            // random array
            int[] randomArray = ArrayGenerator.generateRandomArray(size);
            runMetrics("InsertionSort", "Random", size, insertionSort, randomArray);
            runMetrics("SelectionSort", "Random", size, selectionSort, randomArray);
            runMetrics("BubbleSort", "Random", size, bubbleSort, randomArray);

            // sorted array
            int[] sortedArray = ArrayGenerator.generateSortedArray(size);
            runMetrics("InsertionSort", "Sorted", size, insertionSort, sortedArray);
            runMetrics("SelectionSort", "Sorted", size, selectionSort, sortedArray);
            runMetrics("BubbleSort", "Sorted", size, bubbleSort, sortedArray);

            // reverse-sorted array
            int[] reverseArray = ArrayGenerator.generateReverseSortedArray(size);
            runMetrics("InsertionSort", "Reverse", size, insertionSort, reverseArray);
            runMetrics("SelectionSort", "Reverse", size, selectionSort, reverseArray);
            runMetrics("BubbleSort", "Reverse", size, bubbleSort, reverseArray);

            // almost-sorted array
            int[] almostSortedArray = ArrayGenerator.generateAlmostSortedArray(size);
            runMetrics("InsertionSort", "AlmostSorted", size, insertionSort, almostSortedArray);
            runMetrics("SelectionSort", "AlmostSorted", size, selectionSort, almostSortedArray);
            runMetrics("BubbleSort", "AlmostSorted", size, bubbleSort, almostSortedArray);
        }
    }

    /**
     * Helper method to run a sort, measure its time, and print the results.
     */
    private static void runMetrics(String algorithmName, String arrayType, int size,
                                   Sorter sorter, int[] originalArray) {

        int[] sortedArray = Arrays.copyOf(originalArray, originalArray.length);

        long startTime = System.nanoTime();
        SortMetrics metrics;

        if (sorter instanceof InsertionSort) {
            metrics = sorter.sort(sortedArray);
        } else if (sorter instanceof SelectionSort) {
            metrics = sorter.sort(sortedArray);
        } else {
            metrics = sorter.sort(sortedArray);
        } // I think this might be wrong but IntellJ says I can shorten these like this without declaring
        // the specific instance types.

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

        // print results with metrics
        System.out.printf("%s,%s,%d,%d,%d,%d\n",
                algorithmName,
                arrayType,
                size,
                metrics.getComparisonCount(),
                metrics.getSwapCount(),
                durationMs
        );
    }
}