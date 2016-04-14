package com.ritwik.tp.problems;

import java.util.Arrays;

/**
 *
 * @author ritwik.kumar
 *
 *         Take an array of integers and partition it so that all the even integers in the array precede all the odd
 *         integers in the array. (bonus: Your solution must take linear time in the size of the array and operate
 *         in-place with only a constant amount of extra space.) <br>
 *         sample input : 2,4,7,6,1,3,5,4 <br>
 *         sample output : 2,4,6,4,7,1,3,5
 *
 */
public class EvenOddPartition {

    /**
     * Partitions an array so that all the even integers in the array precede all the odd integers in the array
     *
     * @param arr
     */
    private void inorderEvenOddPartioner(final Integer arr[]) {
        if (arr == null) {
            return;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            final int startElement = arr[startIndex];
            final int endElement = arr[endIndex];
            final boolean isStartEven = startElement % 2 == 0;
            final boolean isEndOdd = endElement % 2 == 1;

            if (isStartEven && isEndOdd) {
                // do nothing and just move ahead/back since elements are in correct position
                startIndex++;
                endIndex--;
            } else if (!isStartEven && !isEndOdd) {
                // Swap the elements and move ahead/back
                arr[startIndex] = endElement;
                arr[endIndex] = startElement;
                startIndex++;
                endIndex--;
            } else if (isStartEven && !isEndOdd) {
                // startElement is in correct position so just increment startIndex
                startIndex++;
            } else if (!isStartEven && isEndOdd) {
                // endElement is in correct position so just decrement endIndex
                endIndex--;
            }

        }
    }


    public static void main(final String[] args) {
        final EvenOddPartition partition = new EvenOddPartition();
        // Test - Null Array
        Integer[] arr = null;
        partition.inorderEvenOddPartioner(arr);
        System.out.println(arr);

        // Test - Blank Array
        arr = new Integer[] {};
        partition.inorderEvenOddPartioner(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(Integer.toString(i)));

        // Test - All Even
        arr = new Integer[] {0, 2, 4, 6, 8, 10, 12};
        partition.inorderEvenOddPartioner(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(Integer.toString(i) + " "));

        // Test - All Odd
        arr = new Integer[] {1, 3, 5, 7, 9};
        partition.inorderEvenOddPartioner(arr);
        System.out.println();
        Arrays.stream(arr).forEach(i -> System.out.print(Integer.toString(i) + " "));

        // Test - Mixed
        arr = new Integer[] {2, 4, 7, 6, 1, 3, 5, 4};
        partition.inorderEvenOddPartioner(arr);
        System.out.println();
        Arrays.stream(arr).forEach(i -> System.out.print(Integer.toString(i) + " "));
    }


}
