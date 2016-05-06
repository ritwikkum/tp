package com.ritwik.tp.atlassian;

import java.io.IOException;

public class FindSubList {

    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(final int nval) {
            val = nval;
            next = null;
        }
    };

    public static LinkedListNode insertNodeIntoList(LinkedListNode head, final int val) {
        if (head == null) {
            head = new LinkedListNode(val);
        } else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            final LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    private static LinkedListNode genrateArrayToList(final int[] arr) {
        LinkedListNode list = null;
        for (int i = 0; i < arr.length; i++) {
            list = insertNodeIntoList(list, arr[i]);
        }
        return list;
    }


    static int find(LinkedListNode listHead, LinkedListNode subListHead) {
        if (listHead == null || subListHead == null) {
            return -1;
        }

        int toReturn = -1;
        int index = 0;
        // First find subListHead in list
        while (listHead.next != null) {
            if (listHead.val == subListHead.val) {
                toReturn = index;
                break;
            }
            listHead = listHead.next;
            index++;
        }
        System.out.println();
        System.out
                .println("toReturn ->" + toReturn + " listHead->" + listHead.val + " subListHead->" + subListHead.val);

        // Now check presence for next items of sublist in list, if head was found
        if (toReturn > -1) {
            while (true) {
                if (listHead == null || subListHead == null) {
                    break;
                }
                System.out.println("cur-list->" + listHead.val + " cur-sub-list->" + subListHead.val);
                if (listHead.val != subListHead.val) {
                    return -1;
                }
                listHead = listHead.next;
                subListHead = subListHead.next;
            }
        }
        // Check if all items of subList is covered
        if (subListHead != null) {
            return -1;
        }
        return toReturn;
    }


    public static void main(final String[] args) throws IOException {
        LinkedListNode list = genrateArrayToList(new int[] {1, 2, 3, 4, 5});
        LinkedListNode subList = genrateArrayToList(new int[] {3, 4, 5});
        System.out.println("Answer ->" + find(list, subList));

        subList = genrateArrayToList(new int[] {4});
        System.out.println("Answer ->" + find(list, subList));

        subList = genrateArrayToList(new int[] {8});
        System.out.println("Answer ->" + find(list, subList));

        subList = genrateArrayToList(new int[] {4, 8});
        System.out.println("Answer ->" + find(list, subList));

        subList = genrateArrayToList(new int[] {4, 5, 6});
        System.out.println("Answer ->" + find(list, subList));
    }
}
