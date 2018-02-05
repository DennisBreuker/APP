package nl.han.asd.app.lesson1;

import java.util.Random;

/**
 * Example demonstrating the big difference between O(N), O(N^2) and O(N^3)
 *
 * @author Dennis Breuker
 */
public class MaxSubSum {

    public static final int MAX_VALUE = 10;
    public static final int N_MIN = 10;
    public static final int N_MAX = 1000000;
    public static final int MULT_FACTOR = 10;

    public static void main(String[] args) {
        for (int n = N_MIN; n <= N_MAX; n *= MULT_FACTOR) {
            int[] list = createRandomFilledArray(n);
            long start = System.currentTimeMillis();
            maxSubSumN(list);
            long stop = System.currentTimeMillis();
            System.out.printf("%,10d\t%,10.3f\n", n, (stop - start) / 1000.0);
        }
    }

    /**
     * Creates an array of length <code>n</code>, filled
     * with random integers between -MAX and MAX
     *
     * @param n The length of the array to be created
     * @return The array with random values
     */
    private static int[] createRandomFilledArray(int n) {
        int[] list = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list[i] = rand.nextInt(2*MAX_VALUE) - MAX_VALUE;
        }
        return list;
    }

    /**
     * Calculates the maximum contiguous sum of an array a.
     * The algorithm is O(N^3)
     *
     * @param a The array
     * @return The maximum contiguous sum
     */
    private static int maxSubSumN3(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++)
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;

                for (int k = i; k <= j; k++)
                    thisSum += a[k];

                if (thisSum > maxSum)
                    maxSum = thisSum;
            }

        return maxSum;
    }

    /**
     * Calculates the maximum contiguous sum of an array a.
     * The algorithm is O(N^2)
     *
     * @param a The array
     * @return The maximum contiguous sum
     */
    private static int maxSubSumN2(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];

                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }

        return maxSum;
    }

    /**
     * Calculates the maximum contiguous sum of an array a.
     * The algorithm is O(N)
     *
     * @param a The array
     * @return The maximum contiguous sum
     */
    private static int maxSubSumN(int[] a) {
        int maxSum = 0, thisSum = 0;

        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];

            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }

        return maxSum;
    }
}
