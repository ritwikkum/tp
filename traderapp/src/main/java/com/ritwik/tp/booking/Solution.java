package com.ritwik.tp.booking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author ritwik.kumar
 *
 */
public class Solution {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final Map<POLYGON_TYPE, Integer> polygonTypeToCountMap = new LinkedHashMap<>();
        polygonTypeToCountMap.put(POLYGON_TYPE.SQUARE, 0);
        polygonTypeToCountMap.put(POLYGON_TYPE.RECTANGLE, 0);
        polygonTypeToCountMap.put(POLYGON_TYPE.OTHER, 0);
        while (sc.hasNextLine()) {
            final String inputLine = sc.nextLine();
            if (inputLine == null || inputLine.isEmpty()) {
                break;
            }
            final Integer[] probablyPolygonSides = getPolygonSides(inputLine);

            if (!checkPolygonPossible(probablyPolygonSides)) {
                polygonTypeToCountMap.put(POLYGON_TYPE.OTHER, polygonTypeToCountMap.get(POLYGON_TYPE.OTHER) + 1);
            } else {
                if (isSquare(probablyPolygonSides)) {
                    polygonTypeToCountMap.put(POLYGON_TYPE.SQUARE, polygonTypeToCountMap.get(POLYGON_TYPE.SQUARE) + 1);
                } else if (isRectangle(probablyPolygonSides)) {
                    polygonTypeToCountMap.put(POLYGON_TYPE.RECTANGLE,
                            polygonTypeToCountMap.get(POLYGON_TYPE.RECTANGLE) + 1);
                } else {
                    polygonTypeToCountMap.put(POLYGON_TYPE.OTHER, polygonTypeToCountMap.get(POLYGON_TYPE.OTHER) + 1);
                }
            }
        }
        sc.close();

        String output = "";
        for (final POLYGON_TYPE polygon_type : polygonTypeToCountMap.keySet()) {
            output += polygonTypeToCountMap.get(polygon_type) + " ";
        }
        System.out.println(output);
    }

    private static Integer[] getPolygonSides(final String inputLine) {
        final String[] probablyPolygonSides = inputLine.split(" ");
        final Integer[] polygonSides = new Integer[probablyPolygonSides.length];
        for (int i = 0; i < probablyPolygonSides.length; i++) {
            final String sideStr = probablyPolygonSides[i];
            final Integer side = Integer.parseInt(sideStr);
            polygonSides[i] = side;
        }
        return polygonSides;
    }

    private static boolean isSquare(final Integer[] probablyPolygonSides) {
        return probablyPolygonSides[0].equals(probablyPolygonSides[1])
                && probablyPolygonSides[1].equals(probablyPolygonSides[2])
                && probablyPolygonSides[2].equals(probablyPolygonSides[3]);
    }

    private static boolean isRectangle(final Integer[] probablyPolygonSides) {
        return probablyPolygonSides[0].equals(probablyPolygonSides[2])
                && probablyPolygonSides[1].equals(probablyPolygonSides[3]);
    }

    private static boolean checkPolygonPossible(final Integer[] probablyPolygonSides) {
        if (probablyPolygonSides.length != 4) {
            return false;
        }
        boolean isValid = true;
        for (final int side : probablyPolygonSides) {
            if (side <= 0) {
                isValid = false;
            }
        }
        return isValid;
    }


    public static enum POLYGON_TYPE {
        SQUARE, RECTANGLE, OTHER;
    }
}
