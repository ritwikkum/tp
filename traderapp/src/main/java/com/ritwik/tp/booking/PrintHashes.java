package com.ritwik.tp.booking;


public class PrintHashes {

    public static void main(String[] args) {
        final int n = 6;
        for (int i = 1; i <= n; i++) {
            String temp = "";
            for (int j = 1; j <= n - i; j++) {
                temp = temp + " ";
            }
            for (int j = n - i; j < n; j++) {
                temp = temp + "#";
            }
            System.out.println(temp);
        }
    }

    static long sumOfIntegers(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

}

