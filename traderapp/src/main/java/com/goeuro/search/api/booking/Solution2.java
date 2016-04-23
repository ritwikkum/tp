package com.goeuro.search.api.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ritwik.kumar
 *
 */
public class Solution2 {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final Map<String, List<String>> sortedStringVsOriginals = new HashMap<>();
        while (sc.hasNextLine()) {
            final String inputString = sc.nextLine();
            if (inputString == null || inputString.isEmpty()) {
                break;
            }
            final char[] chars = inputString.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            sortedString = sortedString.trim();
            sortedString = sortedString.replace(" ", "");
            if (!sortedStringVsOriginals.containsKey(sortedString)) {
                sortedStringVsOriginals.put(sortedString, new ArrayList<String>());
            }
            sortedStringVsOriginals.get(sortedString).add(inputString);
        }
        sc.close();
        final List<String> anagramsCommaSeparatedString = new ArrayList<>();
        for (final String sortedStr : sortedStringVsOriginals.keySet()) {
            final List<String> originals = sortedStringVsOriginals.get(sortedStr);
            Collections.sort(originals);
            String anagrams = "";
            for (final String original : originals) {
                anagrams += original + ",";
            }
            anagramsCommaSeparatedString.add(anagrams.substring(0, anagrams.length() - 1));
        }
        Collections.sort(anagramsCommaSeparatedString);
        for (final String sortedAnagram : anagramsCommaSeparatedString) {
            System.out.println(sortedAnagram);
        }
    }

}
