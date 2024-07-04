package nl.han.asd.app.lesson_2_2_lists_stacks_queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dennis Breuker
 * Illustration of the use of ArrayList versus LinkedList.
 * When to use an ArrayList? When to use a LinkedList?
 * This program gives you the answer!
 */
public class LinkedListVersusArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int N = 100000;
        final String TEXT = "test, ja hallo!";
        
        long time;
        List<String> list;

        printLine();

        // insert at start (index 0)
        // ArrayList
        list = new ArrayList<>();
        time = msInsertAt0(N, list, TEXT);
        System.out.printf("Insert at start (index 0) ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertAt0(N, list, TEXT);
        System.out.printf("Insert at start (index 0) LinkedList: %4d ms\n", time);
        printLine();

        // insert at index 1
        // ArrayList
        list = new ArrayList<>();
        time = msInsertAt1(N, list, TEXT);
        System.out.printf("Insert at index 1 ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertAt1(N, list, TEXT);
        System.out.printf("Insert at index 1 LinkedList: %4d ms\n", time);
        printLine();

        // insert in first tenth (index i/30)
        // ArrayList
        list = new ArrayList<>();
        time = msInsertAtOneThirtieth(N, list, TEXT);
        System.out.printf("Insert at one thirtieth (index i/30) ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertAtOneThirtieth( N, list, TEXT);
        System.out.printf("Insert at one thirtieth (index i/30) LinkedList: %4d ms\n", time);
        printLine();

        // insert in first tenth (index 29/30)
        // ArrayList
        list = new ArrayList<>();
        time = msInsertAtTwentyNineThirtieth(N, list, TEXT);
        System.out.printf("Insert at one thirtieth (index i*29/30) ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertAtTwentyNineThirtieth( N, list, TEXT);
        System.out.printf("Insert at one thirtieth (index i*29/30) LinkedList: %4d ms\n", time);
        printLine();

        // insert in the middle (index i/2)
        // ArrayList
        list = new ArrayList<>();
        time = msInsertInTheMiddle(N, list, TEXT);
        System.out.printf("Insert in the middle (index i/2) ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertInTheMiddle(N, list, TEXT);
        System.out.printf("Insert in the middle (index i/2) LinkedList: %4d ms\n", time);
        printLine();

        // insert at the end-1 (index i-1)
        // ArrayList
        list = new ArrayList<>();
        time = msInsertAtNearEnd(N, list, TEXT);
        System.out.printf("Insert at end-1 (index i-1) ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertAtNearEnd(N, list, TEXT);
        System.out.printf("Insert at end-1 (index i-1) LinkedList: %4d ms\n", time);
        printLine();

        // insert at the end
        // ArrayList
        list = new ArrayList<>();
        time = msInsertAtEnd(N, list, TEXT);
        System.out.printf("Insert at end (index i) ArrayList : %4d ms\n", time);
        // LinkedList
        list = new LinkedList<>();
        time = msInsertAtEnd(N, list, TEXT);
        System.out.printf("Insert at end (index i) LinkedList: %4d ms\n", time);
        printLine();

        // insert at the end2
        // ArrayList
        list = new ArrayList<>();
        time = msAdd(N, list, TEXT);
        System.out.printf("Add to ArrayList : %4d ms\n", time);
        // LinkedList
        List<String> list2 = new LinkedList<>(); // new list, because we are using this in msGetFromMiddle()
        time = msAdd(N, list2, TEXT);
        System.out.printf("Add to LinkedList: %4d ms\n", time);
        printLine();

        // get from the middle (index i/2)
        // ArrayList
        time = msGetFromTheMiddle(N, list);
        System.out.printf("Get from the middle (index i/2) ArrayList : %4d ms\n", time);
        // LinkedList
        time = msGetFromTheMiddle(N, list2);
        System.out.printf("Get from the middle (index i/2) LinkedList: %4d ms\n", time);
        printLine();
    }

    private static long msInsertAt0(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(0, TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }
    
    private static long msInsertAt1(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        list.add(TEXT); // this one separate
        for (int i = 1; i < N; i++) {
            list.add(1, TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

//    private static long msInsertAt100(final int N, List<String> list, final String TEXT) {
//        long start = System.currentTimeMillis();
//        for (int i=0; i<100; i++) {
//            list.add(TEXT); // this one separate
//        }
//        for (int i = 100; i < N; i++) {
//            list.add(100, TEXT);
//        }
//        long stop = System.currentTimeMillis();
//        return stop - start;
//    }
//
//    private static long msInsertAt10000(final int N, List<String> list, final String TEXT) {
//        long start = System.currentTimeMillis();
//        for (int i=0; i<10000; i++) {
//            list.add(TEXT); // this one separate
//        }
//        for (int i = 10000; i < N; i++) {
//            list.add(10000, TEXT);
//        }
//        long stop = System.currentTimeMillis();
//        return stop - start;
//    }
//
    private static long msInsertAtOneThirtieth(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i/30, TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private static long msInsertAtTwentyNineThirtieth(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add((int)(i*29.0/30), TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }
    private static long msInsertInTheMiddle(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i/2, TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private static long msInsertAtNearEnd(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < N; i++) {
            list.add(i-1, TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }
    
    private static long msInsertAtEnd(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i, TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private static long msAdd(final int N, List<String> list, final String TEXT) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(TEXT);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private static long msGetFromTheMiddle(final int N, List<String> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.get(i/2);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private static void printLine() {
        System.out.println("------------------------------------------------------------");
    }
}
