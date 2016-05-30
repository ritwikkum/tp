package com.ritwik.quantcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 
 * @author ritwik.kumar
 *
 */
public class Spreadsheet {
    private static int cols;
    private static int rows;
    private static LinkedList<Cell> cellsWithNoEdges = new LinkedList<>();
    private static HashMap<String, LinkedList<Cell>> dependancyMap = new HashMap<>();
    protected static Cell[][] cells;

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        cols = sc.nextInt();
        rows = sc.nextInt();
        sc.nextLine();
        try {
            cells = new Cell[26][];
            for (int row = 0; row < rows; row++) {
                cells[row] = new Cell[cols];
                for (int col = 0; col < cols; col++) {
                    final Cell cell = cells[row][col] = new Cell();
                    final String input = sc.nextLine().toUpperCase();
                    cell.setInput(input);

                    cell.setName((char) ('A' + row) + String.valueOf(col + 1));
                    cell.setEdgeCount(cell.getReferences().size());
                    if (cell.getEdgeCount() == 0) {
                        cellsWithNoEdges.add(cell);
                    } else {
                        final ArrayList<String> references = cell.getReferences();
                        for (final String string : references) {
                            addDependancyMap(string, cell);
                        }
                    }
                }
            }

            int countEvaluated = 0;
            while (cellsWithNoEdges.size() > 0) {
                final Cell cell = cellsWithNoEdges.removeFirst();
                cell.evaluate();
                countEvaluated++;

                // get every cell x that refer cell y
                final LinkedList<Cell> list = dependancyMap.get(cell.getName());
                if (null == list) {
                    continue;
                }
                for (final Cell cellx : list) {
                    cellx.setEdgeCount(cellx.getEdgeCount() - 1);
                    if (cellx.getEdgeCount() == 0) {
                        cellsWithNoEdges.add(cellx);
                    }
                }
            }

            if (countEvaluated < cols * rows) {
                sc.close();
                throw new Exception(
                    "circular dependency detected: " + countEvaluated + " cells evaluated");
            }

            System.out.println(cols + " " + rows);
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    final Cell cell = cells[row][col];
                    final double d = cell.evaluate();
                    final String s = String.format("%.5f", d);
                    System.out.println(s);
                }
            }


        } catch (final Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        sc.close();
    }

    private static void addDependancyMap(final String string, final Cell cell) {
        LinkedList<Cell> list = dependancyMap.get(string);
        if (null == list) {
            list = new LinkedList<Cell>();
            dependancyMap.put(string, list);
        }
        list.add(cell);
    }

}
