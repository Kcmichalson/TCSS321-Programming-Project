package generators;

import java.util.Random;

/**
 * ArrayGenerator class
 * Utility class with static methods for generating test arrays.
 *
 * @author Kc
 * @version 11/16/25
 */
public class ArrayGenerator {

    private static final Random random = new Random();

    /**
     * Generates random array.
     * @param size Desired size.
     * @return Aray full of random integers.
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int a = 0; a < size; a++) {
            // kept getting too many duplicates I guess this fixes it
            array[a] = random.nextInt(size * 100);
        }
        return array;
    }

    /**
     * Generates sorted array.
     * @param size Desired size.
     * @return Sorted array of integers
     */
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Generates reverse-sorted array.
     * @param size Desired size.
     * @return Reverse sorted array of integers
     */
    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - 1 - i;
        }
        return array;
    }

    /**
     * Generates almost-sorted array.
     * I think this is close to what would be used for the Painter's Algorithm.
     * @param size Desired size.
     * @return Sorted array with 5% of elements swapped.
     */
    public static int[] generateAlmostSortedArray(int size) {
        // start with a sorted array
        int[] array = generateSortedArray(size);

        // 5/100
        int numSwaps = (int) (size * 0.05);

        for (int i = 0; i < numSwaps; i++) {
            // pick two random spots
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);

            // swap them
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return array;
    }
}