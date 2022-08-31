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

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}

