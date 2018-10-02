package nl.han.asd.app.lesson_1_3_sorteeralgoritmes;

import java.util.Random;

public class Sorting {
    public static boolean PRINT_STEPS = true;

    public static void main(String[] args) {
//        int[] list = createRandomlyFilledArray(8);

        int[] list = {8, 6, 0, 7, 5, 3, 1};
        System.out.println("Before sorting");
        printInsertionSortArray(list, 0);
        System.out.println();

//        insertionSort(list);
        mergeSort(list);

        System.out.println("\nAfter sorting");
        printInsertionSortArray(list,list.length);
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int toBeInserted = a[i];

            int j = i;
            while (j > 0 && toBeInserted < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }

            a[j] = toBeInserted;
            if (PRINT_STEPS) {
                printInsertionSortArray(a, i+1);
            }
        }
    }

    public static void printInsertionSortArray(int[] a, int sortedCount) {
        if (sortedCount != 0) {
            System.out.print("[");
        }
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i]);
            if (i == sortedCount-1) {
                System.out.print("]");
            }
            System.out.print("\t");
        }
        System.out.println();
    }

    public static int[] createRandomlyFilledArray(int n) {
        Random rand = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(4 * n);
        }

        return a;
    }

    public static void mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     *
     * @param a        an array of <code>int</code>s.
     * @param tmpArray an array to place the merged result.
     * @param left     the left-most index of the subarray to be sorted.
     * @param right    the right-most index of the subarray to be sorted.
     */
    private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
            if (PRINT_STEPS) {
                printMergedSortArray(a, left, right);
            }
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     *
     * @param a          an array of <code>int</code>s.
     * @param tmpArray   an array to temporarily place the merged result
     * @param leftFirst  the leftmost index of the subarray
     * @param rightFirst the leftmost index of the second half of the subarray
     * @param rightLast  the right-most index of the subarray
     */
    private static void merge(int[] a, int[] tmpArray, int leftFirst, int rightFirst, int rightLast) {
        int leftIndex = leftFirst;
        int leftLast = rightFirst - 1;
        int rightIndex = rightFirst;

        int i = leftFirst;
        while (leftIndex <= leftLast && rightIndex <= rightLast) {
            if (a[leftIndex] <= a[rightIndex]) {
                tmpArray[i] = a[leftIndex];
                leftIndex++;
            } else {
                tmpArray[i] = a[rightIndex];
                rightIndex++;
            }
            i++;
        }

        // copy remainder of left array, if present
        for (int j = leftIndex; j <= leftLast; j++) {
            tmpArray[i++] = a[j];
        }

        // copy remainder of right array, if present
        for (int j = rightIndex; j <= rightLast; j++) {
            tmpArray[i++] = a[j];
        }

        // Copy merged part of tmpArray back to original array
        for (i = leftFirst; i <= rightLast; i++) {
            a[i] = tmpArray[i];
        }
    }

    public static void printMergedSortArray(int[] a, int left, int right) {
        for (int i=0; i<a.length; i++) {
            if (i == left) {
                System.out.print("[");
            }
            System.out.print(a[i]);
            if (i == right) {
                System.out.print("]");
            }
            System.out.print("\t");
        }
        System.out.println();
    }
}

