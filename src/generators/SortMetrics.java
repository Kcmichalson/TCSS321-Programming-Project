package generators;

/**
 * SortMetrics class
 * Stores results from a sort.
 * Return multiple values to evaluate the sort.
 *
 * @author Kc
 * @version 11/16/25
 */
public class SortMetrics {

    private final int myComparisonCount;
    private final int mySwapCount;

    /**
     * Constructor.
     * @param comparisonCount Total number of comparisons.
     * @param swapCount Total number of swaps/moves.
     */
    public SortMetrics(int comparisonCount, int swapCount) {
        myComparisonCount = comparisonCount;
        mySwapCount = swapCount;
    }

    /**
     * Getter for ComparisonCount.
     * @return The comparison count.
     */
    public int getComparisonCount() {
        return myComparisonCount;
    }

    /**
     * Getter for SwapCount.
     * @return The swap count.
     */
    public int getSwapCount() {
        return mySwapCount;
    }
}