
package com.ritwik.tp.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ritwik.kumar
 *
 *         Write a program to find the nth Fibonacci number, i.e. 0, 1, 1, 2, 3, 5, 8, 13 ... <br>
 *         sample input: 6 sample output: 5
 *
 *
 */
public class NthFibonaaci {

    /**
     * Return nth Fibonaaci of a number
     *
     * @param num
     * @return - nth Fibonaaci of a number or -1 for invalid input
     */
    private int fibonaaci(final Integer num) {
        if (num == null || num < 1) {
            return -1;
        }
        // Cache to store previous calculation, add default of 0 and 1
        final List<Integer> cache = new ArrayList<>(num);
        cache.add(0, 0);
        cache.add(1, 1);

        for (int i = 2; i < num; i++) {
            // Add the previous 2 numbers in the series and store it
            cache.add(i, cache.get(i - 1) + cache.get(i - 2));
        }
        return cache.get(num - 1);
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final NthFibonaaci fib = new NthFibonaaci();
        System.out.println("Input -1, fibonaaci = " + fib.fibonaaci(-1));
        System.out.println("Input null, fibonaaci = " + fib.fibonaaci(null));
        System.out.println("Input 0, fibonaaci = " + fib.fibonaaci(0));
        System.out.println("Input 1, fibonaaci = " + fib.fibonaaci(1));
        System.out.println("Input 2, fibonaaci = " + fib.fibonaaci(2));
        System.out.println("Input 5, fibonaaci = " + fib.fibonaaci(5));
        System.out.println("Input 6, fibonaaci = " + fib.fibonaaci(6));
        System.out.println("Input 10, fibonaaci = " + fib.fibonaaci(10));
    }

}
