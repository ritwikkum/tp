package com.goeuro.search.api.booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ritwik.kumar
 *
 */
public class Solution3 {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int sumTosearch = sc.nextInt();
        int arrayElementsCount = sc.nextInt();
        final Map<Integer, Integer> elementVsSearch = new HashMap<Integer, Integer>();
        boolean validPair = false;
        while (arrayElementsCount > 0) {
            final int element = sc.nextInt();
            arrayElementsCount--;
            if (elementVsSearch.get(element) != null && element == elementVsSearch.get(element)) {
                validPair = true;
            } else {
                elementVsSearch.put(element, sumTosearch - element);
            }
        }
        sc.close();
        if (validPair) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
