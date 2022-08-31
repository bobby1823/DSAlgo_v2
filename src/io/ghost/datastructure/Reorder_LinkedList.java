package io.ghost.datastructure;

public class Reorder_LinkedList {

    Node head = null;
    Node tail = null;

    // 1--2--3--5--8--12
    // 1-3--6--9
    public static void main(String[] args) {
        Reorder_LinkedList list = new Reorder_LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(5);
        list.addNode(8);
        list.addNode(12);
        list.addNode(13);

        reOrder(list.head);
        System.out.println(list);
    }

    private static void reOrder(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node l1 = head;
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node l2 = reverse(slow);
        while (l2.next != null) {
            Node temp1 = l1.next;
            l1.next = l2;
            l1 = temp1;

            Node temp2 = l2.next;
            l2.next = l1;
            l2 = temp2;
        }

        System.out.println(head);
    }

    // l1= 1,2,3,5
    // l2= 13,12,8,5
    // result= 1,13,2,12,3,8,5
    public static void merge(Node l1, Node l2) {
        while (l2.next != null) {
            Node temp1 = l1.next;
            l1.next = l2;
            l1 = temp1;

            Node temp2 = l2.next;
            l2.next = l1;
            l2 = temp2;
        }
    }

    public static Node reverse(Node head) {
        if (head == null)
            return null;
        Node newList = head;
        Node prev = null;
        Node curr = head;

        while(newList != null) {
            Node tempNext = newList.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;

            newList = tempNext;
        }

        return prev;
    }

    public void addNode(Integer data) {
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
