/**
 */
package com.ritwik.tp.atlassian;

/**
 * @author ritwik.kumar
 *
 */
public class Robot {
    private int position = 0;
    private int[] mesh = new int[10];
    private int inHold = 0;

    private void performOperations(final String instruction) {
        for (int i = 0; i < instruction.length(); i++) {
            char currentOp = instruction.charAt(i);

            switch (currentOp) {
                case 'P':
                    position = 0;
                    inHold = 1;
                    break;
                case 'M':
                    if (position <= 9) {
                        position++;
                    }
                    break;
                case 'L':
                    if (mesh[position] < 15) {
                        mesh[position] = mesh[position] + inHold;
                        inHold = 0;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println();
        for(int i : mesh) {
            System.out.print(Integer.toHexString(i).toUpperCase());
        }
    }



    /**
     * @param args
     */
    public static void main(String[] args) {
        new Robot().performOperations("PMLPMMMLPMLPMML");
        new Robot().performOperations("PLPLPLPLPLPLPLPLPLPL");
        
    }

}
