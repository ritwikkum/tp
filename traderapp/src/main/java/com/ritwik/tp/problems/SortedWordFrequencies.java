/**
 * Copyright (c) 2015. InMobi, All Rights Reserved.
 */
package com.ritwik.tp.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ritwik.kumar
 *
 *         Given an array of words, find the frequencies of the words, then print in descending order based on the
 *         frequency: <br>
 *         sample input: [AA, CC, BB, BB, CC, CC] <br>
 *         sample output: CC 3 <br>
 *         BB 2 <br>
 *         AA 1
 *
 *
 */
public class SortedWordFrequencies {

    /**
     *
     * @param words
     */
    private void sortAndPrintWordByFrequency(final String[] words) {
        if (words == null || words.length < 1) {
            return;
        }
        // Map to store word to frequencies
        final Map<String, Integer> wordLookup = new HashMap<>();
        // Reverse lookup for frequency to words
        final Map<Integer, Set<String>> frequencyLookup = new HashMap<>();
        // Variable to store max frequency for any word
        int maxFrequency = 0;
        for (final String word : words) {
            // Create map of word to frequencies
            Integer wordCount = wordLookup.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }
            wordLookup.put(word, ++wordCount);
            // Update max frequency
            if (wordCount > maxFrequency) {
                maxFrequency = wordCount;
            }

            // Create map of frequency to words
            Set<String> wordsWithSameFreq = frequencyLookup.get(wordCount);
            if (wordsWithSameFreq == null) {
                wordsWithSameFreq = new HashSet<>();
                frequencyLookup.put(wordCount, wordsWithSameFreq);
            }
            wordsWithSameFreq.add(word);
            // In above step Since the word went to another bucket, remove it from old bucket 
            if (wordCount > 1) {
                frequencyLookup.get(wordCount - 1).remove(word);
            }
        }

        System.out.println("\nOrininal Array");
        Arrays.stream(words).forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // Print words by frequency
        for (int i = maxFrequency; i >= 1; i--) {
            final Set<String> wordSet = frequencyLookup.get(i);
            if (wordSet != null && !wordSet.isEmpty()) {
                for (final String word : wordSet) {
                    System.out.println(word + " -> " + i);
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final SortedWordFrequencies sorted = new SortedWordFrequencies();
        sorted.sortAndPrintWordByFrequency(null);
        sorted.sortAndPrintWordByFrequency(new String[] {});
        sorted.sortAndPrintWordByFrequency(new String[] {"AA", "CC", "BB", "BB", "CC", "CC"});
        sorted.sortAndPrintWordByFrequency(new String[] {"AA", "AA", "BB", "BB", "CC", "CC"});
        sorted.sortAndPrintWordByFrequency(new String[] {"AA", "AA", "AA", "AA", "AA", "AA"});
    }

}
