package io.ghost.datastructure;

import java.util.HashMap;

public class FloydCycleLinkedList {

    Node head = null;
    Node tail = null;

    public static void main(String[] args) {
        FloydCycleLinkedList list = new FloydCycleLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.addCycleNode(list.head, 5);
        // Verify If its acyclic
//        System.out.println(list.detectFloydCycle(list.head));
        System.out.println(list.detectFloydCycleV2(list.head));

        // Question: Find where (data/Node) the cycle presents
        System.out.println("Data where repeatation starts " +list.fetchRepeatedNode(list.head).data);
    }


    /**
     * Remember that to solve this kind of problem just keep in mind that meeting Node and Starting node as to be equated.
     * The Node at which they equate then return that.. THAT IS THE NODE which IS CAUSING CYCLIC
     * @param head
     * @return
     */
    public Node fetchRepeatedNode(Node head) {
        Node meetingNode = detectFloydCycleV2(head);
        Node start = head;
        Node prev = null;
        while(start != meetingNode) {
            start = start.next;
            prev = meetingNode;
            meetingNode = meetingNode.next;
        }
        System.out.println(prev);
        // Now we can make prev.next == null. So by this it will become ACYCLIC (Normal).
        return start;
    }

    // this will add cyclic linked node
    // 1----2-----3-----4-----5------6
    private void addCycleNode(Node head, int i) {
        Node current = head;
        Node toBeAdded = null;
        Node prevNode = null;
        while (current.next != null) {
            if ((Integer) current.data == i)
                toBeAdded = current;
            current = current.next;
        }
        current.next = toBeAdded;
        System.out.println(current +"" + toBeAdded);
    }

    // Approach-1, Space Complexity O(n), using HashMap
    public boolean detectCycleBruteForce(Node head) {
        Node current = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean isFloydCycleDetected = false;
        while (current != null) {
            if (!map.containsKey(current.data)) {
                isFloydCycleDetected = true;
                return isFloydCycleDetected;
            } else {
             map.put((Integer) current.data, (Integer) current.data);
            }
            current = current.next;
        }
        return isFloydCycleDetected;
    }

    // here we maintain two pointers SLOW POINTER and FAST POINTER. if Fast pointer reaches Null then its not Cyclic
    // IF some point of time SLOW pointer and FAST pointer meets then its CYCLIC.
    // This is also called HAIR and TORTORISE problem
    public boolean detectFloydCycle(Node head) {
        Node current = head;
        Node fast = head;
        Node slow = head;
        boolean isFloydCycle = false;
        while (current != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.next == null) {
                isFloydCycle = false;
                break;
            }
            if (slow.data == fast.data) {
                isFloydCycle = true;
                break;
            }

            current = current.next;
        }
        return isFloydCycle;
    }

    public Node detectFloydCycleV2(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }

    public void addNode(int data) {
        Node<Integer> newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
