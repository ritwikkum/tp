package com.ritwik.tp.problems;

/**
 * Java program to reverse a linked list in buckets of given size
 *
 * @author ritwik.kumar
 *
 */
class ReverseLinkedListInBuckets {
    // head of list
    Node head;

    /**
     *
     * @param head
     * @param k
     * @return
     */
    Node reverse(final Node head, final int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        // Reverse first k nodes of linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverse(next, k);
        }
        // prev is now head of input list
        return prev;
    }



    /** Inserts a new Node at front of the list. */
    public void push(final int data) {
        // Allocate the Node & Put in the data
        final Node new_node = new Node(data);
        // Make next of new Node as head
        new_node.next = head;
        // Move the head to point to new Node
        head = new_node;
    }

    /** Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /** Linked list Node */
    class Node {
        int data;
        Node next;

        Node(final int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Drier program to test above functions
     *
     * @param args
     */
    public static void main(final String args[]) {
        final ReverseLinkedListInBuckets llist = new ReverseLinkedListInBuckets();
        // Constructed Linked List is 1->2->3->4->5->6->7->8->8->9->null
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();
        llist.reverse(llist.head, 3);
        System.out.println("Reversed list");
        llist.printList();
    }
}
