/**
 * Copyright (c) 2015. InMobi, All Rights Reserved.
 */
package com.ritwik.tp.booking;

import java.util.Scanner;

/**
 * @author ritwik.kumar
 *
 */
public class SumOfPairEqualToN {



    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        final int size = Integer.parseInt(sc.nextLine());
        final Integer[] arr = new Integer[size];
        int count = 0;
        while (sc.hasNextLine()) {
            final String inputString = sc.nextLine();
            if (inputString == null || inputString.isEmpty()) {
                break;
            }
            arr[count++] = Integer.parseInt(inputString);
        }
        sc.close();
        // final int n = 66;
        // int[] arr = {18, 11, 21, 28, 31, 38, 40, 55, 60, 62};

        int toPrint = 0;
        for (int i = 0; i < arr.length; i++) {
            if (toPrint == 1) {
                break;
            }
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] + arr[j] == n) {
                    toPrint = 1;
                    break;
                }
            }
        }
        System.out.println(toPrint);
    }

}
