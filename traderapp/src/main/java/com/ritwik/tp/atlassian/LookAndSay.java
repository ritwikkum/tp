package com.ritwik.tp.atlassian;

import java.io.IOException;

public class LookAndSay {

    /**
     *
     * @param start
     * @param n
     * @return
     */
    static String lookAndSay(String start, final int n) {
        for (int i = 1; i <= n; i++) {
            start = lookAndSay(start);
        }
        return start;
    }

    /**
     *
     * @param original
     * @return
     */
    static String lookAndSay(final String original) {
        final StringBuffer buf = new StringBuffer();
        char first = original.charAt(0);
        int occurances = 1;
        for (int i = 1; i < original.length(); i++) {
            final char current = original.charAt(i);
            if (first == current) {
                occurances++;
            } else {
                buf.append(occurances).append(first);
                first = current;
                occurances = 1;
            }
        }
        buf.append(occurances).append(first);
        return buf.toString();
    }

    public static void main(final String[] args) throws IOException {
        System.out.println("1 ->" + lookAndSay("1"));
        System.out.println("11 -> " + lookAndSay("11"));
        System.out.println("21 -> " + lookAndSay("21"));
        System.out.println("1211 -> " + lookAndSay("1211"));

        System.out.println("1 ->" + lookAndSay("1", 4));
        System.out.println("11 -> " + lookAndSay("11", 2));
    }

}
