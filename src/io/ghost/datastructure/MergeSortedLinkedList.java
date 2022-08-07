package io.ghost.datastructure;

public class MergeSortedLinkedList {

    Node head = null;
    Node tail = null;

    Node head1 = null;
    Node tail1 = null;
    // 1--2--3--5--8--12
    // 1-3--6--9
    public static void main(String[] args) {
        MergeSortedLinkedList list = new MergeSortedLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(5);
        list.addNode(8);
        list.addNode(12);
        list.addNode(13);

        MergeSortedLinkedList list1 = new MergeSortedLinkedList();
        list1.addNode1(1);
        list1.addNode1(3);
        list1.addNode1(6);
        list1.addNode1(9);

        System.out.println(mergeTwoLists(list.head, list1.head1));
    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1 == null && list2 == null) return null;

        Node finalList = new Node(0);
        Node cur = finalList;
        Node current1 = list1;
        Node current2 = list2;
        while (current1 != null && current2 != null) {
            if ((Integer) current1.data <= (Integer) current2.data)  {
                cur.next = current1;
                current1 = current1.next;
            } else {
                cur.next = current2;
                current2 = current2.next;
            }
            cur = cur.next;
        }
        if (current1 != null) {
            cur.next = current1;
        }
        if (current2 != null) {
            cur.next = current2;
        }
        return finalList.next;
    }

    public void addNode1(Integer data) {
        Node<Integer> newNode = new Node(data);
        if (head1 == null) {
            head1 = newNode;
            tail1 = newNode;
        } else {
            tail1.next = newNode;
            tail1 = newNode;
        }
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
