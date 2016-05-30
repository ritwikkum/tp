package com.ritwik.tp.booking;


/*
 * We have a stream of characters and a word. Let's write a function that reads the stream, one character at a time, and
 * counts how many times this word occurred in the stream.
 *
 * Available API: stream.next_char() // Returns next char in stream or \0 at the end of the stream
 *
 * Function to code: int count_occurrences(Stream stream, String word)
 *
 * Example data: Example Stream output: "thebigfatcatsatonthematcat" (if we iterated over the stream) Example input
 * word: "cat" Example output: 2
 */
public class WordCountInStream {

    private static class Stream {
        final String data;
        int position = 0;

        public Stream(final String data) {
            super();
            this.data = data;
        }

        public char nextChar() {
            if (position >= data.length()) {
                return '\0';
            }
            final char toReturn = data.charAt(position);
            position++;
            return toReturn;
        }

    }


    private static int countOccurrences(final Stream stream, final String word) {
        int count = 0;
        StringBuilder buf = new StringBuilder();
        char current = stream.nextChar();
        while (current != '\0') {
            if (buf.length() >= word.length()) {
                buf = buf.deleteCharAt(0);
            }
            buf.append(current);
            if (buf.toString().equals(word)) {
                count++;
            }
            current = stream.nextChar();
            // linear time compelixtity , since you are reading each char of stream just once
        }
        return count;
    }

    public static void main(final String[] args) {
        System.out.println(countOccurrences(new Stream("thebigfatcatsatonthematcat"), "cat"));
    }
}

