package io.ghost.datastructure;

import java.util.ArrayDeque;
import java.util.Queue;

public class MultiLevel_LinkedList {

    // We will use Queue based solution. Will we Iterate and Store the child Nodes into Queue. Whenever we will get null
    // while iterating then we will pop one Node from Queue.
    public Node flatten(io.ghost.datastructure.MultiLevel_LinkedList.Node head) {
        Queue<Node> queueNodes = new ArrayDeque<>();

        Node l1 = head;
        Node l2 = head;

        while (l1 != null) {
            if (l1.next == null) {
                // The moment it reaches next element as null, then it takes element from Queue and points it to l1.next,which earlier was pointing to null
                l1.next = queueNodes.poll();
            }
            System.out.println(l1.val);

            if (l1.child != null) {
                queueNodes.add(l1.child);
            }
            l1 = l1.next;
        }

        return head;
    }

    public static Node flatten_Using_ConstantSpace(Node head) {
        Node current = head;
        Node last = head;
        Node temp = null;

        // finding the last node
        while (last.next != null) {
            last = last.next;
        }
        while (current != last) {
            // Since we already have a pointer to last node. so taking last node and point to child node.
            if (current.child != null) {
                last.next = current.child;
                // Now again traversing to last node of current.child nodes list.
                temp = current.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                // Making last node as last node of child node list
                last = temp;
            }
            // changing the current node pointer
            current = current.next;
        }

        return head;
    }


    /**
     * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an
     * additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing
     * these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel
     * data structure as shown in the example below.
     *
     * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
     * doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr
     * and before curr.next in the flattened list.
     *
     * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
     */
    // Here we need to flatten based on child
    public static Node flatten_II(Node head) {
        
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}

